package test.java.com.phonebookservice.server;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.phonebookservice.database.ContactsDatabase;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.server.FileDataAccessAdapter;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;

import test.java.com.phonebookservice.util.TestSetUpUtil;

public class TestFileDataAccessAdapter {
    private static final Long CONTACT_ID = 123456L;

    /**
     * reset singleton after each test.
     */
    @AfterEach
    public void resetSingleton() throws Exception {
        Field instance = FileDataAccessAdapter.class.
                getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    /**
     * test file data access adapter with not found filename path.
     */
    @Test
    public void testFileDataAccessAdapterWithNotFoundFileName() {
        final BadRequestException exception = Assertions.assertThrows(
                BadRequestException.class, () -> {
            FileDataAccessAdapter.getInstance("test");
        });

        Assertions.assertEquals(ErrorMessages.ERROR_DATABASE_LINK_IS_INVALID,
                exception.getMessage());
        Assertions.assertEquals(ErrorCode.ERROR_DATABASE_LINK_INVALID, exception
                .getErrorCode());
    }

    /**
     * test file data access adapter with create contact.
     */
    @Test
    public void testFileDataAccessAdapterWithCreateContact() {
        final ContactsDatabase databaseMock = Mockito.mock(
                ContactsDatabase.class);
        final FileDataAccessAdapter adapter = FileDataAccessAdapter
                .getInstance(databaseMock);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.create(new Contact());
        });
    }

    /**
     * test file data access adapter with get null contact.
     */
    @Test
    public void testFileDataAccessAdapterWithGetNullContact() {
        final ContactsDatabase databaseMock = Mockito.mock(
                ContactsDatabase.class);
        final FileDataAccessAdapter adapter = FileDataAccessAdapter.
                getInstance(databaseMock);

        final Contact contact = adapter.get(null);
        Assertions.assertNull(contact);
    }

    /**
     * test file data access adapter with get contact.
     */
    @Test
    public void testFileDataAccessAdapterWithGetContact() {
        final ContactsDatabase databaseMock = Mockito.mock(
                ContactsDatabase.class);
        final Contact existContact = TestSetUpUtil.createContact(
                TestSetUpUtil.CONTACT_LAST_NAME);

        Mockito.when(databaseMock.get(
                TestSetUpUtil.CONTACT_ID)).thenReturn(existContact);
        final FileDataAccessAdapter adapter =  FileDataAccessAdapter.
                getInstance(databaseMock);

        final Contact contact = adapter.get(TestSetUpUtil.CONTACT_ID);
        Assertions.assertNotNull(contact);
        Assertions.assertEquals(
                TestSetUpUtil.CONTACT_LAST_NAME, contact.getLastName());
        Assertions.assertEquals(
                TestSetUpUtil.CONTACT_FIRST_NAME, contact.getFirstName());
    }

    /**
     * test file data access adapter with delete contact.
     */
    @Test
    public void testFileDataAccessAdapterWithDeleteContact() {
        final ContactsDatabase databaseMock = Mockito.mock(
                ContactsDatabase.class);
        final FileDataAccessAdapter adapter = FileDataAccessAdapter.
                getInstance(databaseMock);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.delete(CONTACT_ID);
        });
    }

    /**
     * test file data access adapter with update contact.
     */
    @Test
    public void testFileDataAccessAdapterWithUpdateContact() {
        final ContactsDatabase databaseMock = Mockito.mock(
                ContactsDatabase.class);
        final FileDataAccessAdapter adapter = FileDataAccessAdapter
                .getInstance(databaseMock);
        final Contact contact = TestSetUpUtil.createContact(
                TestSetUpUtil.CONTACT_LAST_NAME);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.update(CONTACT_ID, contact);
        });
    }

    /**
     * test file data access adapter with save contact.
     */
    @Test
    public void testFileDataAccessAdapterWithSaveContact() {
        final ContactsDatabase databaseMock = Mockito.mock(
                ContactsDatabase.class);
        Mockito.doNothing().when(databaseMock).save();
        FileDataAccessAdapter.getInstance(databaseMock).save();

        Mockito.verify(databaseMock, Mockito.times(1)).save();

    }
}
