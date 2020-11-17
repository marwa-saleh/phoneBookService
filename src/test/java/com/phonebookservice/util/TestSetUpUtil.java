package test.java.com.phonebookservice.util;

import java.util.Arrays;

import com.phonebookservice.model.Address;
import com.phonebookservice.model.Contact;
import com.phonebookservice.model.PhoneNumber;
import com.phonebookservice.model.PhoneNumber.PhoneLabel;

public abstract class TestSetUpUtil {
    public static final String CONTACT_FIRST_NAME = "Marwa";
    public static final String CONTACT_LAST_NAME = "Saleh";
    public static final String CONTACT_PHONE_NUMBER = "0123456789";
    public static final String CONTACT_CITY = "Egypt";
    public static final String CONTACT_COUNTRY = "Alexandria";
    public static final String CONTACT_STREET = "Road Street";
    public static final String CONTACT_DISTRICT = "Smouha";
    public static final Long CONTACT_ID = 123456L;
    public static final String NEW_CONTACT_LAST_NAME = "Ahmed";
    public static final String TEST_STRING_VALUE1 = "value1";
    public static final String TEST_STRING_VALUE2 = "value2";
    public static final String TEST_STRING_VALUE3 = "value3";
    public static final String TEST_STRING_VALUE4 = "value4";
    public static final int TEST_ARRAY_SIZE_12 = 12;
    public static final int DEFAULT_ARRAY_SIZE = 10;
    public static final int TEST_ARRAY_SIZE_5 = 5;
    public static final int TEST_ARRAY_SIZE_4 = 4;
    public static final int TEST_ARRAY_SIZE_3 = 3;

    /**
     * create contact object.
     *
     * @param lastName the last name.
     * @return contact
     */
    public static Contact createContact(final String lastName) {
        final Address address = Address.builder().withStreet(CONTACT_STREET)
                .withDistrict(CONTACT_DISTRICT).withCountry(CONTACT_COUNTRY)
                .withCity(CONTACT_CITY).build();

        final PhoneNumber phoneNumber = new PhoneNumber(PhoneLabel.HOME,
                CONTACT_PHONE_NUMBER);

        return Contact.builder().withLastName(lastName)
                .withFirstName(CONTACT_FIRST_NAME)
                .withAddresses(Arrays.asList(address))
                .withPhoneNumbers(Arrays.asList(phoneNumber)).build();
    }
}
