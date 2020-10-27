package main.java.com.phonebookservice.model;

public class Address {
    /**
     * street.
     */
    private String street;
    /**
     * district.
     */
    private String district;
    /**
     * country.
     */
    private String country;

    /**
     * address constructor.
     *
     * @param streetValue   the street.
     * @param districtValue the district.
     * @param countryValue  the country.
     */
    public Address(final String streetValue, final String districtValue,
            final String countryValue) {
        this.street = streetValue;
        this.district = districtValue;
        this.country = countryValue;
    }

}
