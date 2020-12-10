package test.java.com.phonebookservice.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.model.Contact;
import com.phonebookservice.server.FileDataAccessAdapter;
import com.phonebookservice.server.IDataAccessAdapter;

import test.java.com.phonebookservice.util.TestSetUpUtil;

public class TestFileDataAccessAdapter {
    private static final Long CONTACT_ID = 123456L;

    /**
     * test file data access adapter with create contact.
     */
    @Test
    public void testFileDataAccessAdapterWithCreateContact() {
        final IDataAccessAdapter databaseMock = new FileDataAccessAdapter();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.create(new Contact());
        });
    }

    /**
     * test file data access adapter with delete contact.
     */
    @Test
    public void testFileDataAccessAdapterWithDeleteContact() {
        final IDataAccessAdapter databaseMock = new FileDataAccessAdapter();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.delete(CONTACT_ID);
        });
    }

    /**
     * test file data access adapter with update contact.
     */
    @Test
    public void testFileDataAccessAdapterWithUpdateContact() {
        final IDataAccessAdapter databaseMock = new FileDataAccessAdapter();
        final Contact contact = TestSetUpUtil
                .createContact(TestSetUpUtil.CONTACT_LAST_NAME);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.update(CONTACT_ID, contact);
        });
    }

}
