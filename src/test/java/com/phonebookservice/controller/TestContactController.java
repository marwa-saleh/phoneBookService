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

public class TestContactController {

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
                    contacController.create(createContact("marwa"));
                });

        Assertions.assertEquals("database not found", exception.getMessage());
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

        Assertions.assertEquals("invalid object", exception.getMessage());
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
                    contacController.create(createContact(""));
                });

        Assertions.assertEquals(
                "missing one of mandatory fields:{firstName,phoneNumber}",
                exception.getMessage());
    }

    /**
     * test contact.
     */
    @Test
    public void testContact() {
        DBIf databaseMock = Mockito.mock(DBIf.class);

        Model model = createContact("marwa");
        Mockito.doAnswer(result -> {
            return "sucess";
        }).when(databaseMock).create((Contact) model);

        final ContactController contacController = new ContactController(
                databaseMock);
        contacController.create(model);

        Mockito.verify(databaseMock, Mockito.times(1)).create((Contact) model);
    }

    private Model createContact(final String firstName) {
        final Address address = new Address("road", "camp shezar",
                "alexandria");
        final PhoneNumber phoneNumber = new PhoneNumber("home", "0123456789");
        return new Contact(firstName, "saleh", "egypt",
                Lists.newArrayList(address), Lists.newArrayList(phoneNumber),
                null);
    }
}
