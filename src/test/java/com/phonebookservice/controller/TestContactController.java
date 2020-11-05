package test.java.com.phonebookservice.controller;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.phonebookservice.controller.ContactController;
import com.phonebookservice.dispatcher.QueryParam;
import com.phonebookservice.dispatcher.QueryParamType;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.exception.NotFoundException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.server.IDataAccessAdapter;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;

import test.java.com.phonebookservice.util.TestSetUpUtil;

public class TestContactController {

    /**
     * reset singleton after each test.
     */
    @AfterEach
    public void resetSingleton() throws Exception {
        Field instance = ContactController.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
    }

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

        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_MISSING,
                exception.getErrorCode());
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
                    contacController.create(TestSetUpUtil.createContact(null));
                });

        Assertions.assertEquals(ErrorMessages.ERROR_LAST_NAME_IS_NULL,
                exception.getMessage());

        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_LAST_NAME_MISSING,
                exception.getErrorCode());
    }

    /**
     * test create contact.
     */
    @Test
    public void testCreateContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final Contact contact = TestSetUpUtil
                .createContact(TestSetUpUtil.CONTACT_LAST_NAME);
        Mockito.doNothing().when(databaseMock).create(contact);

        ContactController.getInstance(databaseMock).create(contact);

        Mockito.verify(databaseMock, Mockito.times(1)).create(contact);
    }

    /**
     * test get contact.
     */
    @Test
    public void testGetContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        final Contact existContact = TestSetUpUtil
                .createContact(TestSetUpUtil.CONTACT_LAST_NAME);
        Mockito.when(databaseMock.get(TestSetUpUtil.CONTACT_ID))
                .thenReturn(existContact);

        Contact contact = ContactController.getInstance(databaseMock)
                .get(TestSetUpUtil.CONTACT_ID);

        Assertions.assertEquals(existContact, contact);
    }

    /**
     * test get contact with contact not exist.
     */
    @Test
    public void testGetContactWithContactNotExist() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        Mockito.when(databaseMock.get(TestSetUpUtil.CONTACT_ID))
                .thenReturn(null);

        final NotFoundException exception = Assertions
                .assertThrows(NotFoundException.class, () -> {
                    ContactController.getInstance(databaseMock)
                            .get(TestSetUpUtil.CONTACT_ID);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_IS_NOT_FOUND,
                exception.getMessage());

        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_NOT_FOUND,
                exception.getErrorCode());
    }

    /**
     * test get contact with contact id is null.
     */
    @Test
    public void testGetContactWithContactIdIsNull() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);

        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    ContactController.getInstance(databaseMock).get(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_ID_IS_NULL,
                exception.getMessage());

        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_ID_MISSING,
                exception.getErrorCode());
    }

    /**
     * test delete contact.
     */
    @Test
    public void testDeleteContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        Mockito.doNothing().when(databaseMock).delete(TestSetUpUtil.CONTACT_ID);
        Mockito.when(databaseMock.get(TestSetUpUtil.CONTACT_ID))
                .thenReturn(new Contact());

        ContactController.getInstance(databaseMock)
                .delete(TestSetUpUtil.CONTACT_ID);

        Mockito.verify(databaseMock, Mockito.times(1))
                .delete(TestSetUpUtil.CONTACT_ID);
    }

    /**
     * test delete contact with contact not exist.
     */
    @Test
    public void testDeleteContactWithContactNotExist() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        Mockito.when(databaseMock.get(TestSetUpUtil.CONTACT_ID))
                .thenReturn(null);

        final NotFoundException exception = Assertions
                .assertThrows(NotFoundException.class, () -> {
                    ContactController.getInstance(databaseMock)
                            .delete(TestSetUpUtil.CONTACT_ID);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_IS_NOT_FOUND,
                exception.getMessage());

        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_NOT_FOUND,
                exception.getErrorCode());
    }

    /**
     * test delete contact with contact id is null.
     */
    @Test
    public void testDeleteContactWithContactIdIsNull() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);

        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    ContactController.getInstance(databaseMock).delete(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_ID_IS_NULL,
                exception.getMessage());

        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_ID_MISSING,
                exception.getErrorCode());
    }

    /**
     * test update contact.
     */
    @Test
    public void testUpdateContact() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);

        final Contact existContact = TestSetUpUtil
                .createContact(TestSetUpUtil.CONTACT_LAST_NAME);
        final Contact updatedContact = TestSetUpUtil
                .createContact(TestSetUpUtil.NEW_CONTACT_LAST_NAME);

        Mockito.when(databaseMock.get(TestSetUpUtil.CONTACT_ID))
                .thenReturn(existContact);
        Mockito.when(
                databaseMock.update(TestSetUpUtil.CONTACT_ID, updatedContact))
                .thenReturn(updatedContact);

        final Contact contact = ContactController.getInstance(databaseMock)
                .update(TestSetUpUtil.CONTACT_ID, updatedContact);

        Assertions.assertEquals(updatedContact, contact);
    }

    /**
     * test get all contacts.
     */
    @Test
    public void testGetAllContacts() {
        final IDataAccessAdapter databaseMock = Mockito
                .mock(IDataAccessAdapter.class);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            ContactController.getInstance(databaseMock)
                    .getAll(new HashMap<QueryParamType, QueryParam>());
        });
    }
}
