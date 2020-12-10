package com.phonebookservice.server;

import java.util.Arrays;

import com.google.common.collect.BiMap;
import com.phonebookservice.model.Address;
import com.phonebookservice.model.Contact;
import com.phonebookservice.model.PhoneNumber;
import com.phonebookservice.model.PhoneNumber.PhoneLabel;

public final class ContactConverter {
    public static final String SPLITTER = ",";

    private ContactConverter() {

    }

    /**
     * map string to contact.
     *
     * @param splitLine the line.
     *
     * @return contact.
     */
    public static Contact mapStringToContact(final String[] splitLine) {
        final Address address = Address.builder().withStreet(splitLine[3])
                .withCity(splitLine[4]).build();

        final PhoneNumber phoneNumber = new PhoneNumber(PhoneLabel.MOBILE,
                splitLine[5]);

        return Contact.builder().withLastName(splitLine[1])
                .withFirstName(splitLine[2])
                .withAddresses(Arrays.asList(address))
                .withPhoneNumbers(Arrays.asList(phoneNumber)).build();
    }

    /**
     * map contact to string.
     *
     * @param myContactMap the map.
     * @param contact      the contact.
     *
     * @return string.
     */
    public static String mapContactToString(
            final BiMap<String, Contact> myContactMap, final Contact contact) {
        return new StringBuilder(myContactMap.inverse().get(contact))
                .append(SPLITTER).append(contact.getLastName()).append(SPLITTER)
                .append(contact.getFirstName()).append(SPLITTER)
                .append(!contact.getAddresses().isEmpty()
                        ? contact.getAddresses().get(0).getStreet()
                        : "")
                .append(SPLITTER)
                .append(!contact.getAddresses().isEmpty()
                        ? contact.getAddresses().get(0).getCity()
                        : "")
                .append(SPLITTER)
                .append(!contact.getPhoneNumbers().isEmpty()
                        ? contact.getPhoneNumbers().get(0).getNumber()
                        : "")
                .toString();
    }
}
