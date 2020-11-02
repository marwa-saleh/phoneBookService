package com.phonebookservice.model;

/**
 * Address builder class.
 *
 * @author Marwa Saleh
 */
public class AddressBuilder {
    private String street;
    private String district;
    private String country;
    private String city;

    /**
     * Initialization of address builder.
     */
    public AddressBuilder() {

    }

    /**
     * with street.
     *
     * @param street the street.
     * @return address builder.
     */
    public AddressBuilder withStreet(final String street) {
        this.street = street;
        return this;
    }

    /**
     * with district.
     *
     * @param district the district.
     * @return address builder.
     */
    public AddressBuilder withDistrict(final String district) {
        this.district = district;
        return this;
    }

    /**
     * with country.
     *
     * @param country the country.
     * @return address builder.
     */
    public AddressBuilder withCountry(final String country) {
        this.country = country;
        return this;
    }

    /**
     * with city.
     *
     * @param city the city.
     * @return address builder.
     */
    public AddressBuilder withCity(final String city) {
        this.city = city;
        return this;
    }

    /**
     * build.
     *
     * @return address.
     */
    public Address build() {
        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        address.setDistrict(district);
        address.setStreet(street);
        return address;
    }

}
