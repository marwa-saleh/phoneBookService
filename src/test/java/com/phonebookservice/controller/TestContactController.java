package test.java.com.phonebookservice.controller;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

import main.java.com.phonebookservice.controller.ContactController;
import main.java.com.phonebookservice.model.Address;
import main.java.com.phonebookservice.model.Contact;
import main.java.com.phonebookservice.model.Model;
import main.java.com.phonebookservice.server.DBIf;

public class TestContactController {
    @Test
    public void testContact() {
        DBIf databse = null;
        ContactController contacController = new ContactController(databse);
        contacController.create(createContact());
    }

    private Model createContact() {
        final Address address = new Address("road", "camp shezar", "alexandria");
        Integer home = 01234567;
        final List<Integer> phoneNumbers = Lists.newArrayList(home);
        return new Contact("marwa", "saleh", "egypt", Lists.newArrayList(address), phoneNumbers, null);
    }
}
