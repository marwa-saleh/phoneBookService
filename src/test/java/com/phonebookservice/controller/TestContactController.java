package test.java.com.phonebookservice.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.google.common.collect.Lists;

import main.java.com.phonebookservice.controller.ContactController;
import main.java.com.phonebookservice.exception.PhoneBookControllerException;
import main.java.com.phonebookservice.model.Address;
import main.java.com.phonebookservice.model.Contact;
import main.java.com.phonebookservice.model.Model;
import main.java.com.phonebookservice.model.PhoneNumber;
import main.java.com.phonebookservice.server.DBIf;
import main.java.com.phonebookservice.server.FileAdapter;
import main.java.com.phonebookservice.util.Messages;
import main.java.com.phonebookservice.util.Util;

public class TestContactController {
    private static final String CONTACT_FIRST_NAME = "Marwa";
    private static final String CONTACT_LAST_NAME = "Saleh";
    private static final String CONTACT_PHONE_NUMBER = "0123456789";
    private static final String CONTACT_CITY = "Egypt";
    private static final String CONTACT_COUNTRY = "Alexandria";
    private static final String CONTACT_STREET = "Road Street";
    private static final String CONTACT_DISTRICT = "Smouha";
    private static final String CONTACT_PHONE_LABEL = "Home";

    /**
     * test contact with no database.
     */
    @Test
    public void testContactWithNoDatabase() {
        final DBIf databse = null;
        final ContactController contacController = new ContactController(
                databse);
        final Exception exception = Assertions
                .assertThrows(PhoneBookControllerException.class, () -> {
                    contacController.create(createContact(CONTACT_FIRST_NAME,
                            CONTACT_PHONE_NUMBER));
                });

        Assertions.assertEquals(Messages.ERROR_DATABASE_NOT_FOUND,
                exception.getMessage());
    }

    /**
     * test contact with no contact object.
     */
    @Test
    public void testContactWithNoContact() {
        final DBIf databse = new FileAdapter();
        final ContactController contacController = new ContactController(
                databse);
        final Exception exception = Assertions
                .assertThrows(PhoneBookControllerException.class, () -> {
                    contacController.create(null);
                });

        Assertions.assertEquals(Messages.ERROR_OBJECT_INVALID,
                exception.getMessage());
    }

    /**
     * test contact with no first name in contact object.
     */
    @Test
    public void testContactWithNoFirstName() {
        final DBIf databse = new FileAdapter();
        final ContactController contacController = new ContactController(
                databse);
        final Exception exception = Assertions
                .assertThrows(PhoneBookControllerException.class, () -> {
                    contacController
                            .create(createContact("", CONTACT_PHONE_NUMBER));
                });

        Assertions.assertEquals(Messages.ERROR_MANDATORY_FIELDS_MISSING,
                exception.getMessage());
    }

    /**
     * test contact with no phone number in contact object.
     */
    @Test
    public void testContactWithNoPhoneNumber() {
        final DBIf databse = new FileAdapter();
        final ContactController contacController = new ContactController(
                databse);
        final Exception exception = Assertions
                .assertThrows(PhoneBookControllerException.class, () -> {
                    contacController
                            .create(createContact(CONTACT_FIRST_NAME, ""));
                });

        Assertions.assertEquals(Messages.ERROR_MANDATORY_FIELDS_MISSING,
                exception.getMessage());
    }

    /**
     * test contact.
     */
    @Test
    public void testContact() {
        DBIf databaseMock = Mockito.mock(DBIf.class);

        Model model = createContact(CONTACT_FIRST_NAME, CONTACT_PHONE_NUMBER);
        Mockito.doNothing().when(databaseMock).create((Contact) model);

        final ContactController contacController = new ContactController(
                databaseMock);
        contacController.create(model);

        Mockito.verify(databaseMock, Mockito.times(1)).create((Contact) model);
    }

    private Model createContact(final String firstName, final String number) {
        final Address address = new Address(CONTACT_STREET, CONTACT_DISTRICT,
                CONTACT_COUNTRY);

        PhoneNumber phoneNumber = null;

        if (!Util.isNullOrEmptyString(number)) {
            phoneNumber = new PhoneNumber(CONTACT_PHONE_LABEL, number);
        }

        return new Contact(firstName, CONTACT_LAST_NAME, CONTACT_CITY,
                Lists.newArrayList(address),
                phoneNumber == null ? null : Lists.newArrayList(phoneNumber),
                null);
    }
}
