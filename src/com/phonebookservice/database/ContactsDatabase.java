package com.phonebookservice.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.phonebookservice.model.Contact;
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
     * save contacts.
     */
    public void save() {
        // TODO to be done every time duration
        this.parser.writeContacts(this.contactList);
    }

}
