package com.phonebookservice.controller;

import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.server.IDataAccessAdapter;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;
import com.phonebookservice.util.StringUtility;

/**
 * Contact controller.
 *
 * @author Marwa Saleh
 */
public final class ContactController extends AbstractController<Contact> {
    private static ContactController singleton;
    private static IDataAccessAdapter<Contact> database;

    /**
     * Initialization of contact controller.
     *
     * @param database the database.
     */
    private ContactController(final IDataAccessAdapter database) {
        super(database);

        if (database == null) {
            throw new IllegalArgumentException(
                    ErrorMessages.ERROR_DATABASE_NOT_FOUND);
        }
        this.database = super.getDatabase();
    }

    /**
     * Get instance of contact controller.
     *
     * @param database the database.
     * @return contact controller.
     */
    public static ContactController getInstance(
            final IDataAccessAdapter database) {
        if (singleton == null) {
            singleton = new ContactController(database);
        }

        return singleton;
    }

    /**
     * get contact.
     *
     * @param contactId the contact id.
     *
     * @return contact the contact.
     */
    @Override
    public Contact get(final Long contactId) {
        ContactController.checkContactId(contactId);
        final Contact contact = database.get(contactId);
        ContactController.validateExisitingContact(contact);
        return contact;
    }

    /**
     * create contact.
     *
     * @param contact the contact
     */
    @Override
    public void create(final Contact contact) {
        ContactController.validateContact(contact);
        database.create(contact);
    }

    /**
     * update contact.
     *
     * @param contactId the contact id.
     * @param contact   the updates of contact.
     *
     * @return contact the updated contact.
     */
    @Override
    public Contact update(final Long contactId, final Contact contact) {
        ContactController.checkContactId(contactId);
        ContactController.validateContact(contact);
        final Contact existedContact = database.get(contactId);
        ContactController.validateExisitingContact(existedContact);
        return database.update(contactId, contact);
    }

    /**
     * delete contact.
     *
     * @param contactId the contact id.
     */
    @Override
    public void delete(final Long contactId) {
        ContactController.checkContactId(contactId);
        final Contact contact = database.get(contactId);
        ContactController.validateExisitingContact(contact);
        database.delete(contactId);

    }

    private static void validateContact(final Contact contact) {
        if (contact == null) {
            throw new BadRequestException(ErrorMessages.ERROR_CONTACT_IS_NULL,
                    ErrorCode.ERROR_CONTACT_MISSING);
        }

        if (StringUtility.isNullOrEmptyString(contact.getLastName())) {
            throw new BadRequestException(ErrorMessages.ERROR_LAST_NAME_IS_NULL,
                    ErrorCode.ERROR_CONTACT_LAST_NAME_MISSING);
        }
    }

    private static void validateExisitingContact(final Contact contact) {
        if (contact == null) {
            throw new BadRequestException(
                    ErrorMessages.ERROR_CONTACT_IS_NOT_FOUND,
                    ErrorCode.ERROR_CONTACT_NOT_FOUND);
        }
    }

    private static void checkContactId(final Long contactId) {
        if (contactId == null) {
            throw new BadRequestException(
                    ErrorMessages.ERROR_CONTACT_ID_IS_NULL,
                    ErrorCode.ERROR_CONTACT_ID_MISSING);
        }
    }
}
