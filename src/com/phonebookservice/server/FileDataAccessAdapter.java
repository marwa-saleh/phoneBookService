package com.phonebookservice.server;

import com.phonebookservice.model.Contact;

/**
 * file data access adapter.
 *
 * @author Marwa Saleh
 */
public class FileDataAccessAdapter implements IDataAccessAdapter<Contact> {

    /**
     * create contact.
     *
     * @param contact the contact
     */
    @Override
    public final void create(final Contact contact) {
        throw new UnsupportedOperationException();
    }

}
