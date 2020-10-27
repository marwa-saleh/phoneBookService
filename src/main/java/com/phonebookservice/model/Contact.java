package main.java.com.phonebookservice.model;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Contact implements Model {
	private String firstName;
	private String lastName;
	private String city;
	private List<Address> addresses;
	private List<Integer> phoneNumbers;
	private List<SocialProfiles> socialProfiles;

	public Contact(final String firstName) {
		this.firstName = firstName;
	}

	public Contact(final String firstName, final String lastName, final String city, final List<Address> addresses,
			final List<Integer> phoneNumbers, final List<SocialProfiles> socialProfiles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.addresses = addresses;
		this.phoneNumbers = phoneNumbers;
		this.socialProfiles = socialProfiles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(final List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(final List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<SocialProfiles> getSocialProfiles() {
		return socialProfiles;
	}

	public void setSocialProfiles(final List<SocialProfiles> socialProfiles) {
		this.socialProfiles = socialProfiles;
	}

	public String toJson(Contact contact) {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			json = mapper.writeValueAsString(contact);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}
