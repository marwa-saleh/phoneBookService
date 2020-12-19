package com.phonebookservice.server;

import com.phonebookservice.config.Config;
import com.phonebookservice.config.Config.ConfigKey;
import com.phonebookservice.database.ContactsDatabase;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;
import com.phonebookservice.util.StringUtility;

/**
 * file data access adapter.
 *
 * @author Marwa Saleh
 */
public final class FileDataAccessAdapter
        implements IDataAccessAdapter<Contact> {

    private static FileDataAccessAdapter singleton;
    private final ContactsDatabase contactsDb;

    /**
     * Initialization of file data access adapter.
     *
     * @param databaseLink the database link.
     */
    private FileDataAccessAdapter(final String databaseLink) {
        if (StringUtility.isNullOrEmptyString(databaseLink)
                || !databaseLink.equals(ConfigKey.FILENAME_PATH.getKey())) {
            throw new BadRequestException(
                    ErrorMessages.ERROR_DATABASE_LINK_IS_INVALID,
                    ErrorCode.ERROR_DATABASE_LINK_INVALID);
        }

        // to-do: To be added in startup
        Config.getInstance();
        this.contactsDb = ContactsDatabase
                .getInstance(Config.get(ConfigKey.FILENAME_PATH.getKey()));
    }

    /**
     * Get instance of file data access adapter.
     *
     * @param databaseLink
     * @return file data access adapter.
     */
    public static FileDataAccessAdapter getInstance(final String databaseLink) {
        if (singleton == null) {
            singleton = new FileDataAccessAdapter(databaseLink);
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
        if (contactId == null) {
            return null;
        }

        return this.contactsDb.get(contactId);
    }

    /**
     * create contact.
     *
     * @param contact the contact.
     */
    @Override
    public void create(final Contact contact) {
        throw new UnsupportedOperationException();
    }

    /**
     * update contact.
     *
     * @param contactId the contact id.
     * @param contact   the contact.
     *
     * @return contact.
     */
    @Override
    public Contact update(final Long contactId, final Contact contact) {
        throw new UnsupportedOperationException();
    }

    /**
     * delete contact.
     *
     * @param contactId the contact id.
     */
    @Override
    public void delete(final Long contactId) {
        throw new UnsupportedOperationException();
    }

    /**
     * save contacts.
     *
     */
    @Override
    public void save() {
        this.contactsDb.save();
    }
}
