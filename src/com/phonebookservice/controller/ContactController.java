package com.phonebookservice.controller;

import java.util.HashMap;
import java.util.List;

import com.phonebookservice.dispatcher.QueryParam;
import com.phonebookservice.dispatcher.QueryParamType;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.exception.NotFoundException;
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
        final Contact contact = super.getDatabase().get(contactId);
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
        super.getDatabase().create(contact);
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
        final Contact existedContact = getDatabase().get(contactId);
        ContactController.validateExisitingContact(existedContact);
        return super.getDatabase().update(contactId, contact);
    }

    /**
     * delete contact.
     *
     * @param contactId the contact id.
     */
    @Override
    public void delete(final Long contactId) {
        ContactController.checkContactId(contactId);
        final Contact contact = getDatabase().get(contactId);
        ContactController.validateExisitingContact(contact);
        super.getDatabase().delete(contactId);
    }

    /**
     * get list of contacts based on filters.
     *
     * @param paramValues the hashmap of query params.
     * @return list of contacts.
     */
    @Override
    public List<Contact> getAll(
            final HashMap<QueryParamType, QueryParam> paramValues) {
        throw new UnsupportedOperationException();
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
            throw new NotFoundException(
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
