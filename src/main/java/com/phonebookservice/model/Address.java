package main.java.com.phonebookservice.model;

public class Address {
    private String street;
    private String district;
    private String country;

    public Address(final String street, final String district, final String country) {
        this.street = street;
        this.district = district;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

}
