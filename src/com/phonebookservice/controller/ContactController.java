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

    /**
     * Initialization of contact controller.
     *
     * @param database the database
     */
    public ContactController(final IDataAccessAdapter database) {
        super(database);

        if (database == null) {
            throw new IllegalArgumentException(
                    ErrorMessages.ERROR_DATABASE_NOT_FOUND);
        }
    }

    /**
     * create contact.
     *
     * @param contact the contact
     */
    @Override
    public void create(final Contact contact) {
        final IDataAccessAdapter database = getDatabase();
        validateContact(contact);
        database.create(contact);
    }

    private static void validateContact(final Contact contact) {
        if (contact == null) {
            throw new BadRequestException(ErrorMessages.ERROR_CONTACT_MISSING,
                    ErrorCode.ERROR_CONTACT_IS_NULL);
        }

        if (StringUtility.isNullOrEmptyString(contact.getLastName())) {
            throw new BadRequestException(
                    ErrorMessages.ERROR_CONTACT_LAST_NAME_MISSING,
                    ErrorCode.ERROR_LAST_NAME_IS_NULL);
        }
    }

}
