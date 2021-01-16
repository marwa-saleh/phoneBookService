package com.phonebookservice.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;
import com.phonebookservice.util.MyArrayList;
import com.phonebookservice.util.StringUtility;

public final class ContactsDatabase {
    private static ContactsDatabase singleton;
    private final ContactsFileParser contactsFileParser;
    private final List<Contact> contactList;
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

    /**
     * create contact.
     *
     * @param contact the contact
     */
    public void create(final Contact contact) {
        if (this.contactList == null) {
            return;

        }

        this.validateContact(contact);
        final Random rand = new Random();
        final String lastNameOfNewContact = contact.getLastName();
        final Object[] contactsArray = this.contactList.toArray();
        int length = contactsArray.length - 1;
        int currentIndex = 0;

        while (currentIndex <= length) {
            final int middle = currentIndex + (length - currentIndex) / 2;

            if (((Contact) contactsArray[middle]).getLastName()
                    .compareTo(lastNameOfNewContact) < 0) {
                currentIndex = middle + 1;
            } else {
                length = middle - 1;
            }
        }

        contact.setId(this.getcontactId(rand, contact));
        this.contactList.add(currentIndex, contact);
        this.idToContactMap.put(contact.getId(), contact);
    }

    private void validateContact(final Contact contact) {
        if (this.idToContactMap.get(contact.getId()) != null) {
            throw new BadRequestException(
                    ErrorMessages.ERROR_CONTACT_ID_ALREADY_EXISIT,
                    ErrorCode.ERROR_CONTACT_ID_ALREADY_EXISIT);
        }

        if (StringUtility.isNullOrEmptyString(contact.getLastName())) {
            throw new BadRequestException(ErrorMessages.ERROR_CONTACT_INVALID,
                    ErrorCode.ERROR_CONTACT_INVALID);
        }
    }

    private long getcontactId(final Random rand, final Contact contact) {
        final Long randomIdValue = Long.valueOf(rand.nextInt(10000));

        return contact.getId() != null ? contact.getId()
                : this.idToContactMap.get(randomIdValue) == null ? randomIdValue
                        : getcontactId(rand, contact);
    }

}
