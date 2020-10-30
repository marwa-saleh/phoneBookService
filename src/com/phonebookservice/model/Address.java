package com.phonebookservice.model;

/**
 * Address class.
 *
 * @author Marwa Saleh
 */
public class Address {
    private String street;
    private String district;
    private String country;
    private String city;

    /**
     * Initialization of address.
     *
     * @param street   the street.
     * @param district the district.
     * @param country  the country.
     * @param city     the city.
     */
    public Address(final String street, final String district,
            final String country, final String city) {
        this.street = street;
        this.district = district;
        this.country = country;
        this.city = city;
    }

}
