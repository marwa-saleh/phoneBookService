package main.java.com.phonebookservice.server;

import main.java.com.phonebookservice.model.Contact;

public interface DBIf {
    public void create(final Contact model);
}
