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
     */
    public Address() {

    }

    /**
     * get street.
     *
     * @return street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * set street.
     *
     * @param street the street.
     */
    public void setStreet(final String street) {
        this.street = street;
    }

    /**
     * get district.
     *
     * @return district.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * set district.
     *
     * @param district the district.
     */
    public void setDistrict(final String district) {
        this.district = district;
    }

    /**
     * get country.
     *
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * set country.
     *
     * @param country the country.
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * get city.
     *
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * set city.
     *
     * @param city the city.
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * builder.
     *
     * @return address builder.
     */
    public static AddressBuilder builder() {
        return new AddressBuilder();
    }
}
