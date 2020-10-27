package main.java.com.phonebookservice.controller;

import main.java.com.phonebookservice.exception.PhoneBookException;
import main.java.com.phonebookservice.model.Contact;
import main.java.com.phonebookservice.model.Model;
import main.java.com.phonebookservice.server.DBIf;
import main.java.com.phonebookservice.util.Util;

public class ContactController extends AbstractController {

    public ContactController(final DBIf databse) {
        super(databse);
    }

    @Override
    public void create(final Model model) {
        final DBIf database = getDatabase();

        if (database == null) {
            throw new PhoneBookException("database not found");
        }

        if (model instanceof Contact) {
            final Contact contact = (Contact) model;
            final String errorMessage = validateContact(contact);

            if (!Util.isNullOrEmptyString(errorMessage)) {
                throw new PhoneBookException(errorMessage);
            }

            database.create(contact);

        } else {
            throw new PhoneBookException("invalid object");
        }
    }

    private String validateContact(final Contact contact) {
        if (contact == null) {
            return "contact object is null";
        }

        if (Util.isNullOrEmptyString(contact.getFirstName()) && Util.isNullOrEmptyList(contact.getPhoneNumbers())) {
            return "missing mandatory fields";
        }

        return null;
    }

}
