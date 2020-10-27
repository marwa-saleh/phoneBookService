package main.java.com.phonebookservice.controller;

import main.java.com.phonebookservice.exception.PhoneBookControllerException;
import main.java.com.phonebookservice.model.Contact;
import main.java.com.phonebookservice.model.Model;
import main.java.com.phonebookservice.server.DBIf;
import main.java.com.phonebookservice.util.Util;

public class ContactController extends AbstractController {

    /**
     * contact controller constructor.
     *
     * @param databse the database
     */
    public ContactController(final DBIf databse) {
        super(databse);
    }

    @Override
    public final void create(final Model model) {
        final DBIf database = getDatabase();

        if (database == null) {
            throw new PhoneBookControllerException("database not found");
        }

        if (model == null || !(model instanceof Contact)) {
            throw new PhoneBookControllerException("invalid object");
        }

        final Contact contact = (Contact) model;
        final String errorMessage = validateContact(contact);

        if (!Util.isNullOrEmptyString(errorMessage)) {
            throw new PhoneBookControllerException(errorMessage);
        }

        database.create(contact);

    }

    private String validateContact(final Contact contact) {
        if (Util.isNullOrEmptyString(contact.getFirstName())
                || Util.isNullOrEmptyList(contact.getPhoneNumbers())) {
            return "missing one of mandatory fields:{firstName,phoneNumber}";
        }

        return null;
    }

}
