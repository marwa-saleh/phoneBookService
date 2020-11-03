package test.java.com.phonebookservice.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.phonebookservice.controller.ContactController;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.model.Address;
import com.phonebookservice.model.Contact;
import com.phonebookservice.model.PhoneNumber;
import com.phonebookservice.model.PhoneNumber.PhoneLabel;
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
     * test create contact with no database.
     */
    @Test
    public void testCreateContactWithNoDatabase() {
        final IllegalArgumentException exception = Assertions
                .assertThrows(IllegalArgumentException.class, () -> {
                    ContactController.getInstance(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_DATABASE_NOT_FOUND,
                exception.getMessage());
    }

    /**
     * test create contact with no contact object.
     */
    @Test
    public void testCreateContactWithNoContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final ContactController contacController = ContactController
                .getInstance(databaseMock);
        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    contacController.create(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_IS_NULL,
                exception.getMessage());
    }

    /**
     * test create contact with no last name in contact object.
     */
    @Test
    public void testCreateContactWithNoLastName() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final ContactController contacController = ContactController
                .getInstance(databaseMock);
        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    contacController.create(createContact(null));
                });

        Assertions.assertEquals(ErrorMessages.ERROR_LAST_NAME_IS_NULL,
                exception.getMessage());
    }

    /**
     * test create contact.
     */
    @Test
    public void testCreateContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final Contact contact = createContact(CONTACT_LAST_NAME);
        Mockito.doNothing().when(databaseMock).create(contact);

        ContactController.getInstance(databaseMock).create(contact);

        Mockito.verify(databaseMock, Mockito.times(1)).create(contact);
    }

    private Contact createContact(final String lastName) {
        final Address address = Address.builder().withStreet(CONTACT_STREET)
                .withDistrict(CONTACT_DISTRICT).withCountry(CONTACT_COUNTRY)
                .withCity(CONTACT_CITY).build();

        final PhoneNumber phoneNumber = new PhoneNumber(PhoneLabel.HOME,
                CONTACT_PHONE_NUMBER);

        return Contact.builder().withLastName(lastName)
                .withFirstName(CONTACT_FIRST_NAME)
                .withAddresses(Arrays.asList(address))
                .withPhoneNumbers(Arrays.asList(phoneNumber)).build();
    }
}
