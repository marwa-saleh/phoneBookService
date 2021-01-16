package com.phonebookservice.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;
import com.phonebookservice.util.MyArrayList;
import com.phonebookservice.util.StringUtility;

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
        if (StringUtility.isNullOrEmptyString(fileName)) {
            throw new InternalServerException(
                    ErrorMessages.ERROR_FILENAME_IS_NULL_OR_EMPTY,
                    ErrorCode.ERROR_FILENAME_IS_NULL_OR_EMPTY);
        }

        this.idToContactMap = new HashMap<>();
        this.contactsFileParser = new ContactsFileParser(fileName);
        final Collection<Contact> contacts = contactsFileParser.readContacts();
        this.contactList = new MyArrayList<Contact>();

        for (Contact contact : contacts) {
            this.contactList.add(contact);
            this.idToContactMap.put(contact.getId(), contact);
        }
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
        if (contactId == null) {
            return null;
        }

        return this.idToContactMap.get(contactId);
    }

    /**
     * save contacts.
     */
    public void save() {
        // TODO to be done every time duration
        this.contactsFileParser.writeContacts(this.contactList);
    }
}
