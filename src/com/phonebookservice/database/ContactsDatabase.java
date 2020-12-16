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
    private final Map<String, Contact> idTocontactMap;

    /**
     * Contacts database constructor.
     *
     * @param fileName the file name.
     */
    private ContactsDatabase(final String fileName) {
        this.contactList = new MyArrayList<Contact>();
        this.idTocontactMap = new HashMap<>();
        this.parser = new ContactsFileParser(fileName);
        readContacts();
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

    private void readContacts() {
        final Collection<Contact> contacts = parser.readContacts();
        this.contactList.addAll(contacts);

        for (Contact contact : contacts) {
            this.idTocontactMap.put(contact.getId(), contact);
        }
    }

    /**
     * get contact.
     *
     * @param contactId the contact id.
     * @return contact.
     */
    public Contact get(final Long contactId) {
        return this.idTocontactMap.get(contactId.toString());
    }

    /**
     * save contacts.
     */
    public void save() {
        // TODO to be done every time duration
        this.parser.writeContacts(this.contactList);
    }

}
