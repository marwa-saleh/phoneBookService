package com.phonebookservice.server;

import java.util.HashMap;

import com.phonebookservice.model.Contact;
import com.phonebookservice.util.MyArrayList;

/**
 * file data access adapter.
 *
 * @author Marwa Saleh
 */
public final class FileDataAccessAdapter
        implements IDataAccessAdapter<Contact> {
    private static FileDataAccessAdapter singleton;
    private FileParser parser = null;

    /**
     * Initialization of file data access adapter.
     */
    private FileDataAccessAdapter() {
        this.parser = new FileParser(new MyArrayList<Contact>(),
                new HashMap<>());
        load();
    }

    /**
     * Get instance of file data access adapter.
     *
     * @return file data access adapter.
     */
    public static FileDataAccessAdapter getInstance() {
        if (singleton == null) {
            singleton = new FileDataAccessAdapter();
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

        return this.parser.getMyContactMap().get(contactId.toString());
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
        // TODO to be done every time duration
        this.parser.writeContact();
    }

    /**
     * load contacts.
     *
     */
    private void load() {
        this.parser.readContact();
    }
}
