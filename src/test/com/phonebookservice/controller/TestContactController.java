package test.com.phonebookservice.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.phonebookservice.controller.ContactController;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.model.Address;
import com.phonebookservice.model.Contact;
import com.phonebookservice.model.ContactBuilder;
import com.phonebookservice.model.PhoneNumber;
import com.phonebookservice.model.PhoneNumber.PhoneLabel;
import com.phonebookservice.server.FileDataAccessAdapter;
import com.phonebookservice.server.IDataAccessAdapter;
import com.phonebookservice.util.ErrorMessages;

public class TestContactController {
    private static final String CONTACT_FIRST_NAME = "Marwa";
    private static final String CONTACT_LAST_NAME = "Saleh";
    private static final String CONTACT_PHONE_NUMBER = "0123456789";
    private static final String CONTACT_CITY = "Egypt";
    private static final String CONTACT_COUNTRY = "Alexandria";
    private static final String CONTACT_STREET = "Road Street";
    private static final String CONTACT_DISTRICT = "Smouha";

    /**
     * test contact with no database.
     */
    @Test
    public void testContactWithNoDatabase() {
        final IllegalArgumentException exception = Assertions
                .assertThrows(IllegalArgumentException.class, () -> {
                    new ContactController(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_DATABASE_NOT_FOUND,
                exception.getMessage());
    }

    /**
     * test contact with no contact object.
     */
    @Test
    public void testContactWithNoContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final ContactController contacController = new ContactController(
                databaseMock);
        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    contacController.create(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_MISSING,
                exception.getErrorMessage());
    }

    /**
     * test contact with no first name in contact object.
     */
    @Test
    public void testContactWithNoFirstName() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final ContactController contacController = new ContactController(
                databaseMock);
        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    contacController.create(createContact(null));
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_LAST_NAME_MISSING,
                exception.getErrorMessage());
    }

    /**
     * test contact with no first name in contact object.
     */
    @Test
    public void testFileDataAccessAdapter() {
        final IDataAccessAdapter databaseMock = new FileDataAccessAdapter();
        final ContactController contacController = new ContactController(
                databaseMock);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            contacController.create(createContact(CONTACT_LAST_NAME));
        });
    }

    /**
     * test contact.
     */
    @Test
    public void testContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final Contact contact = createContact(CONTACT_LAST_NAME);
        Mockito.doNothing().when(databaseMock).create(contact);

        final ContactController contacController = new ContactController(
                databaseMock);
        contacController.create(contact);

        Mockito.verify(databaseMock, Mockito.times(1)).create(contact);
    }

    private Contact createContact(final String lastName) {
        final Address address = new Address(CONTACT_STREET, CONTACT_DISTRICT,
                CONTACT_COUNTRY, CONTACT_CITY);

        final PhoneNumber phoneNumber = new PhoneNumber(PhoneLabel.HOME,
                CONTACT_PHONE_NUMBER);

        return new ContactBuilder(lastName).withFirstName(CONTACT_FIRST_NAME)
                .withAddresses(Arrays.asList(address))
                .withPhoneNumbers(Arrays.asList(phoneNumber)).build();
    }
}
