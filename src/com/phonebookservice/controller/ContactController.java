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
public class ContactController extends AbstractController<Contact> {
    private static ContactController singleton;

    /**
     * Initialization of contact controller.
     *
     * @param database the database.
     */
    protected ContactController(final IDataAccessAdapter database) {
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
     * create contact.
     *
     * @param contact the contact
     */
    @Override
    public void create(final Contact contact) {
        final IDataAccessAdapter database = super.getDatabase();
        ContactController.validateContact(contact);
        database.create(contact);
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
}
