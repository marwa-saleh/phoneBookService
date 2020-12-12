package com.phonebookservice.server;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import com.phonebookservice.model.Address;
import com.phonebookservice.model.Contact;
import com.phonebookservice.model.PhoneNumber;
import com.phonebookservice.model.PhoneNumber.PhoneLabel;
import com.phonebookservice.util.CollectionUtility;

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
    public static Contact convertStringToContact(final String[] splitLine) {
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
    public static String convertContactToString(
            final Map<String, Contact> myContactMap, final Contact contact) {

        for (Entry<String, Contact> entry : myContactMap.entrySet()) {
            if (entry.getValue().equals(contact)) {
                final String street = CollectionUtility
                        .isNotNullOrEmptyList(contact.getAddresses())
                                ? contact.getAddresses().get(0).getStreet()
                                : "";

                final String city = CollectionUtility
                        .isNotNullOrEmptyList(contact.getAddresses())
                                ? contact.getAddresses().get(0).getCity()
                                : "";

                final String number = CollectionUtility
                        .isNotNullOrEmptyList(contact.getPhoneNumbers())
                                ? contact.getPhoneNumbers().get(0).getNumber()
                                : "";
                return new StringBuilder(entry.getKey()).append(SPLITTER)
                        .append(contact.getLastName()).append(SPLITTER)
                        .append(contact.getFirstName()).append(SPLITTER)
                        .append(street).append(SPLITTER).append(city)
                        .append(SPLITTER).append(number).toString();
            }
        }

        return null;
    }
}
