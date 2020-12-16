package com.phonebookservice.database;

import java.util.Collection;

import com.phonebookservice.model.Contact;

public interface IContactsParser {

    /**
     * read contact.
     *
     * @return contact the contact.
     */
    Collection<Contact> readContacts();

    /**
     * write contact.
     *
     * @param contacts the contact list
     */
    void writeContacts(Collection<Contact> contacts);

}
