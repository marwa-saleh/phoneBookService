package main.java.com.phonebookservice.model;

public class Address {
    private String street;
    private String district;
    private String country;

    /**
     * address constructor.
     *
     * @param street   the street.
     * @param district the district.
     * @param country  the country.
     */
    public Address(final String street, final String district,
            final String country) {
        this.street = street;
        this.district = district;
        this.country = country;
    }

}
