package com.phonebookservice.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.phonebookservice.model.Contact;
import com.phonebookservice.util.MyArrayList;

public final class ContactsDatabase {
    private static ContactsDatabase singleton;
    private final ContactsFileParser contactsFileParser;
    private final Collection<Contact> contactList;
    private final Map<Long, Contact> idToContactMap;

    /**
     * Contacts database constructor.
     *
     * @param fileName the file name.
     */
    private ContactsDatabase(final String fileName) {
        this.idToContactMap = new HashMap<>();
        this.contactsFileParser = new ContactsFileParser(fileName);
        this.contactList = //
                new MyArrayList<Contact>(contactsFileParser.readContacts());
        addInContactMap();
    }

    /**
     * Get instance of file data access adapter.
     *
     * @param fileName the file name.
     * @return contacts database.
     */
    public static ContactsDatabase getInstance(final String fileName) {
        if (singleton == null) {
            singleton = new ContactsDatabase(fileName);
        }

        return singleton;
    }

    /**
     * get contact.
     *
     * @param contactId the contact id.
     * @return contact.
     */
    public Contact get(final Long contactId) {
        return this.idToContactMap.get(contactId);
    }

    /**
     * save contacts.
     */
    public void save() {
        // TODO to be done every time duration
        this.contactsFileParser.writeContacts(this.contactList);
    }

    private void addInContactMap() {
        for (Contact contact : this.contactList) {
            this.idToContactMap.put(contact.getId(), contact);
        }
    }
}
