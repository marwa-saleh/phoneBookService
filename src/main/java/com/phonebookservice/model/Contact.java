package main.java.com.phonebookservice.model;

import java.util.List;

public class Contact implements Model {
    /**
     * first name.
     */
    private String firstName;
    /**
     * last name.
     */
    private String lastName;
    /**
     * city.
     */
    private String city;
    /**
     * list of addresses.
     */
    private List<Address> addresses;
    /**
     * list of phone numbers.
     */
    private List<PhoneNumber> phoneNumbers;
    /**
     * list of social profiles.
     */
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
     * @param firstNameValue       the first name.
     * @param lastNameValue        the last name.
     * @param cityValue            the city.
     * @param listOfAddress        the addresses.
     * @param listOfPhoneNumbers   the phone numbers.
     * @param listOfSocialProfiles the social profiles.
     */
    public Contact(final String firstNameValue, final String lastNameValue,
            final String cityValue, final List<Address> listOfAddress,
            final List<PhoneNumber> listOfPhoneNumbers,
            final List<SocialProfile> listOfSocialProfiles) {
        this.firstName = firstNameValue;
        this.lastName = lastNameValue;
        this.city = cityValue;
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
