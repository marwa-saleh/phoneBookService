package test.com.phonebookservice.database;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import com.phonebookservice.database.ContactsDatabase;
import com.phonebookservice.database.ContactsFileParser;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;

import test.java.com.phonebookservice.util.TestSetUpUtil;

public class TestContactsDatabase {
    private static String testDatabaseFile = "testFiles/TestDatabaseFile";

    /**
     * reset singleton after each test.
     */
    @AfterEach
    public void resetSingleton() throws Exception {
        Field instance = ContactsDatabase.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);

        ContactsFileParser parser = new ContactsFileParser(
                "testFiles/TestDatabaseFile");
        parser.writeContacts(new ArrayList<>());
    }

    /**
     * test contacts database with not found filename path.
     */
    @Test
    public void testContactsDatabaseWithNotFoundFileName() {
        final InternalServerException exception = Assertions
                .assertThrows(InternalServerException.class, () -> {
                    ContactsDatabase.getInstance(null);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_FILENAME_IS_NULL_OR_EMPTY,
                exception.getMessage());
        Assertions.assertEquals(ErrorCode.ERROR_FILENAME_IS_NULL_OR_EMPTY,
                exception.getErrorCode());
    }

    /**
     * test contacts database with get contact.
     */
    @Test
    public void testContactsDatabaseWithGetContact() {
        ContactsFileParser parser = new ContactsFileParser(testDatabaseFile);
        List<Contact> contacts = Lists.newArrayList(
                TestSetUpUtil.createContact(TestSetUpUtil.CONTACT_LAST_NAME));
        parser.writeContacts(contacts);

        final ContactsDatabase database = ContactsDatabase
                .getInstance(testDatabaseFile);

        final Contact contact = database.get(TestSetUpUtil.CONTACT_ID);
        Assertions.assertNotNull(contact);
        Assertions.assertEquals(TestSetUpUtil.CONTACT_LAST_NAME,
                contact.getLastName());
        Assertions.assertEquals(TestSetUpUtil.CONTACT_FIRST_NAME,
                contact.getFirstName());
    }

    /**
     * test create contact with id.
     */
    @Test
    public void testCreateContactWithId() {
        final ContactsDatabase database = ContactsDatabase
                .getInstance(testDatabaseFile);
        final Contact newContact = TestSetUpUtil
                .createContact(TestSetUpUtil.NEW_CONTACT_LAST_NAME, 987L);
        database.create(newContact);
        database.save();
        final Contact contact = database.get(987L);

        Assertions.assertNotNull(contact);
        Assertions.assertEquals(TestSetUpUtil.NEW_CONTACT_LAST_NAME,
                contact.getLastName());
        Assertions.assertEquals(TestSetUpUtil.CONTACT_FIRST_NAME,
                contact.getFirstName());
    }

    /**
     * test create contact with existing id.
     */
    @Test
    public void testCreateContactWithNoId() {
        final ContactsDatabase database = ContactsDatabase
                .getInstance(testDatabaseFile);
        final Contact newContact = TestSetUpUtil
                .createContact(TestSetUpUtil.NEW_CONTACT_LAST_NAME, 987L);
        database.create(newContact);
        final Contact existContact = TestSetUpUtil
                .createContact(TestSetUpUtil.CONTACT_LAST_NAME, 987L);

        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    database.create(existContact);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_ID_ALREADY_EXISIT,
                exception.getMessage());
        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_ID_ALREADY_EXISIT,
                exception.getErrorCode());
    }

    /**
     * test create contact with no last name.
     */
    @Test
    public void testCreateContactWithNoLastName() {
        final ContactsDatabase database = ContactsDatabase
                .getInstance(testDatabaseFile);
        final Contact newContact = TestSetUpUtil.createContact("");

        final BadRequestException exception = Assertions
                .assertThrows(BadRequestException.class, () -> {
                    database.create(newContact);
                });

        Assertions.assertEquals(ErrorMessages.ERROR_CONTACT_INVALID,
                exception.getMessage());
        Assertions.assertEquals(ErrorCode.ERROR_CONTACT_INVALID,
                exception.getErrorCode());
    }
}
