package test.com.phonebookservice.database;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import com.phonebookservice.database.ContactsDatabase;
import com.phonebookservice.database.ContactsFileParser;
import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;

import test.java.com.phonebookservice.util.TestSetUpUtil;

public class TestContactsDatabase {
	/**
     * reset singleton after each test.
     */
    @AfterEach
    public void resetSingleton() throws Exception {
        Field instance = ContactsDatabase.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        
    	ContactsFileParser parser = new ContactsFileParser("testFiles/TestDatabaseFile");
    	parser.writeContacts(new ArrayList<>());
    }
    
    /**
     * write contacts in test file.
     */
    @BeforeEach
    public void writeContacts() {
    	ContactsFileParser parser = new ContactsFileParser("testFiles/TestDatabaseFile");
    	List<Contact> contacts = Lists.newArrayList(TestSetUpUtil
                 .createContact(TestSetUpUtil.CONTACT_LAST_NAME));
    	parser.writeContacts(contacts);
    }
    
    /**
     * test contacts database with not found filename path.
     */
    @Test
    public void testContactsDatabaseWithNotFoundFileName() {
    	final BadRequestException exception =  
    			Assertions.assertThrows(BadRequestException.class, () -> {
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
    	final ContactsDatabase database =	
    			ContactsDatabase.getInstance("testFiles/TestDatabaseFile");
    	
    	final Contact contact = database.get(TestSetUpUtil.CONTACT_ID);
    	Assertions.assertNotNull(contact);
    	Assertions.assertEquals(TestSetUpUtil.CONTACT_LAST_NAME, contact.getLastName());
        Assertions.assertEquals(TestSetUpUtil.CONTACT_FIRST_NAME, contact.getFirstName());
    }
}
