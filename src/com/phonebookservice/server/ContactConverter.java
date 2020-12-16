package com.phonebookservice.server;

import java.util.Arrays;

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
        final Address address = Address.builder()
                .withStreet(splitLine[ContactColumns.STREET.getKey()])
                .withCity(splitLine[ContactColumns.CITY.getKey()]).build();

        final PhoneNumber phoneNumber = new PhoneNumber(PhoneLabel.MOBILE,
                splitLine[ContactColumns.PHONE_NUMBER.getKey()]);

        return Contact.builder().withId(splitLine[ContactColumns.ID.getKey()])
                .withLastName(splitLine[ContactColumns.LAST_NAME.getKey()])
                .withFirstName(splitLine[ContactColumns.FIRST_NAME.getKey()])
                .withAddresses(Arrays.asList(address))
                .withPhoneNumbers(Arrays.asList(phoneNumber)).build();
    }

    /**
     * map contact to string.
     *
     * @param contact the contact.
     *
     * @return string.
     */
    public static String convertContactToString(final Contact contact) {
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
        return new StringBuilder(contact.getId())
                .append(ContactConverter.SPLITTER).append(contact.getLastName())
                .append(ContactConverter.SPLITTER)
                .append(contact.getFirstName())
                .append(ContactConverter.SPLITTER).append(street)
                .append(ContactConverter.SPLITTER).append(city)
                .append(ContactConverter.SPLITTER).append(number).toString();

    }
}
