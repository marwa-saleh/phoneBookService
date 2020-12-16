package com.phonebookservice.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.phonebookservice.model.Contact;
import com.phonebookservice.util.CollectionUtility;
import com.phonebookservice.util.MyArrayList;

public final class ContactsDatabase {
    private static ContactsDatabase singleton;
    private final ContactsFileParser parser;
    private final Collection<Contact> contactList;
    private final Map<String, Contact> contactMap;

    /**
     * Contacts database constructor.
     *
     * @param databaseLink the database link.
     */
    private ContactsDatabase(final String databaseLink) {
        this.contactList = new MyArrayList<Contact>();
        this.contactMap = new HashMap<>();
        this.parser = new ContactsFileParser(databaseLink);
        readContacts();
    }

    /**
     * Get instance of file data access adapter.
     *
     * @param databaseLink the database link.
     * @return contacts database.
     */
    public static ContactsDatabase getInstance(final String databaseLink) {
        if (singleton == null) {
            singleton = new ContactsDatabase(databaseLink);
        }

        return singleton;
    }

    private void readContacts() {
        final Collection<Contact> contacts = parser.readContacts();
        this.contactList.addAll(contacts);

        for (Contact contact : contacts) {
            this.contactMap.put(contact.getId(), contact);
        }
    }

    /**
     * get contact.
     *
     * @param contactId the contact id.
     * @return contact.
     */
    public Contact get(final Long contactId) {
        return this.contactMap.get(contactId.toString());
    }

    /**
     * create the contact.
     *
     * @param contact the contact
     */
    public void create(final Contact contact) {
        final Random rand = new Random();
        final String lastNameOfNewContact = contact.getLastName();

        if (CollectionUtility.isNotNullOrEmptyList(this.contactList)) {
            final MyArrayList<Contact> contacts = //
                    (MyArrayList<Contact>) this.contactList;
            final Object[] contactsArray = contacts.toArray();
            int length = contactsArray.length - 1;
            int firstIndex = 0;

            while (firstIndex <= length) {
                final int middle = firstIndex + (length - firstIndex) / 2;

                if (((Contact) contactsArray[middle]).getLastName()
                        .compareTo(lastNameOfNewContact) < 0) {
                    firstIndex = middle + 1;
                } else {
                    length = middle - 1;
                }
            }

            contacts.add(firstIndex, contact);
            this.addContactInMap(rand, contact);
        }

    }

    /**
     * save contacts.
     */
    public void save() {
        // TODO to be done every time duration
        this.parser.writeContacts(this.contactList);
    }

    private void addContactInMap(final Random rand, final Contact contact) {
        final String randomIdValue = String.valueOf(rand.nextInt(10000));

        if (this.contactMap.get(randomIdValue) == null) {
            this.contactMap.put(randomIdValue, contact);
        } else {
            addContactInMap(rand, contact);
        }
    }
}
