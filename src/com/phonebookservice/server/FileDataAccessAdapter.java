package com.phonebookservice.server;

import com.phonebookservice.model.Contact;

public class FileDataAccessAdapter implements IDataAccessAdapter<Contact> {

    @Override
    public final void create(final Contact contact) {
        throw new UnsupportedOperationException();
    }

}
