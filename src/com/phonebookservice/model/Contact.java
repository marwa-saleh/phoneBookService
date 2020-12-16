package com.phonebookservice.model;

import java.util.List;

import com.phonebookservice.model.builder.ContactBuilder;

/**
 * Contact class.
 *
 * @author Marwa Saleh
 */
public class Contact implements Model {
    private String id;
    private String firstName;
    private String lastName;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;
    private List<SocialProfile> socialProfiles;

    /**
     * Initialization of contact.
     */
    public Contact() {
    }

    /**
     * get id.
     *
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * set id the id.
     *
     * @param id the id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * get first name.
     *
     * @return first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * set firstName the first name.
     *
     * @param firstName the first name.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * get phone numbers.
     *
     * @return list of phone numbers.
     */
    public List<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    /**
     * set phone numbers.
     *
     * @param phoneNumbers the list of phone Numbers
     */
    public void setPhoneNumbers(final List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * get last name.
     *
     * @return last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * set last name.
     *
     * @param lastName the lastName.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * get addresses.
     *
     * @return list of addresses.
     */
    public List<Address> getAddresses() {
        return this.addresses;
    }

    /**
     * set addresses.
     *
     * @param addresses the list of addresses.
     */
    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * get social profiles.
     *
     * @return list of social profile.
     */
    public List<SocialProfile> getSocialProfiles() {
        return this.socialProfiles;
    }

    /**
     * set social profiles.
     *
     * @param socialProfiles the list of social profiles.
     */
    public void setSocialProfiles(final List<SocialProfile> socialProfiles) {
        this.socialProfiles = socialProfiles;
    }

    /**
     * builder.
     *
     * @return contact builder.
     */
    public static ContactBuilder builder() {
        return new ContactBuilder();
    }
}
