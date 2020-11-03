package com.phonebookservice.model.builder;

import java.util.List;

import com.phonebookservice.model.Address;
import com.phonebookservice.model.Contact;
import com.phonebookservice.model.PhoneNumber;
import com.phonebookservice.model.SocialProfile;

/**
 * Contact builder class.
 *
 * @author Marwa Saleh
 */
public class ContactBuilder {
    private String firstName;
    private String lastName;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;
    private List<SocialProfile> socialProfiles;

    /**
     * Initialization of contact builder.
     */
    public ContactBuilder() {
    }

    /**
     * set phone numbers.
     *
     * @param phoneNumbers the list of phone numbers.
     * @return contact builder
     */
    public ContactBuilder withPhoneNumbers(
            final List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    /**
     * set first name.
     *
     * @param firstName the first name.
     * @return contact builder
     */
    public ContactBuilder withFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * set last name.
     *
     * @param lastName the last name.
     * @return contact builder
     */
    public ContactBuilder withLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * set addresses.
     *
     * @param addresses the addresses.
     * @return contact builder
     */
    public ContactBuilder withAddresses(final List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    /**
     * set social profile.
     *
     * @param socialProfiles the social profile.
     * @return contact builder
     */
    public ContactBuilder withSocialProfiles(
            final List<SocialProfile> socialProfiles) {
        this.socialProfiles = socialProfiles;
        return this;
    }

    /**
     * build.
     *
     * @return contact.
     */
    public Contact build() {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddresses(addresses);
        contact.setPhoneNumbers(phoneNumbers);
        contact.setSocialProfiles(socialProfiles);
        return contact;
    }

}
