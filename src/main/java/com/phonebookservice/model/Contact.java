package main.java.com.phonebookservice.model;

import java.util.List;

public class Contact implements Model {
    private String firstName;
    private String lastName;
    private String city;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;
    private List<SocialProfile> socialProfiles;

    /**
     * contact constructor.
     *
     * @param firstNameValue the first name.
     */
    public Contact(final String firstNameValue) {
        this.firstName = firstNameValue;
    }

    /**
     * contact constructor.
     *
     * @param firstName            the first name.
     * @param lastName             the last name.
     * @param city                 the city.
     * @param listOfAddress        the addresses.
     * @param listOfPhoneNumbers   the phone numbers.
     * @param listOfSocialProfiles the social profiles.
     */
    public Contact(final String firstName, final String lastName,
            final String city, final List<Address> listOfAddress,
            final List<PhoneNumber> listOfPhoneNumbers,
            final List<SocialProfile> listOfSocialProfiles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.addresses = listOfAddress;
        this.phoneNumbers = listOfPhoneNumbers;
        this.socialProfiles = listOfSocialProfiles;
    }

    /**
     * get first name.
     *
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get phonenumbers.
     *
     * @return phonenumbers
     */
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

}
