package main.java.com.phonebookservice.server;

import main.java.com.phonebookservice.model.Contact;

public interface DBIf {
    /**
     * create contact.
     *
     * @param contact the contact
     */
    void create(Contact contact);
}
