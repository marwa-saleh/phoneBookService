package test.java.com.phonebookservice.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.config.Config.ConfigKey;
import com.phonebookservice.controller.ContactController;
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
        final IDataAccessAdapter databaseMock = FileDataAccessAdapter
                .getInstance(ConfigKey.FILE_PATH.getKey());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.create(new Contact());
        });
    }

    /**
     * test file data access adapter with get contact.
     */
    @Test
    public void testFileDataAccessAdapterWithGetContact() {
        FileDataAccessAdapter adapter = FileDataAccessAdapter
                .getInstance(ConfigKey.FILE_PATH.getKey());
        Contact contact = ContactController.getInstance(adapter)
                .get(TestSetUpUtil.CONTACT_ID);
        Assertions.assertNotNull(contact);
    }

    /**
     * test file data access adapter with delete contact.
     */
    @Test
    public void testFileDataAccessAdapterWithDeleteContact() {
        final IDataAccessAdapter databaseMock = FileDataAccessAdapter
                .getInstance(ConfigKey.FILE_PATH.getKey());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.delete(CONTACT_ID);
        });
    }

    /**
     * test file data access adapter with update contact.
     */
    @Test
    public void testFileDataAccessAdapterWithUpdateContact() {
        final IDataAccessAdapter databaseMock = FileDataAccessAdapter
                .getInstance(ConfigKey.FILE_PATH.getKey());
        final Contact contact = TestSetUpUtil
                .createContact(TestSetUpUtil.CONTACT_LAST_NAME);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.update(CONTACT_ID, contact);
        });
    }

}
