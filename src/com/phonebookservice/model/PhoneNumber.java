package com.phonebookservice.model;

public class PhoneNumber {
    public enum PhoneLabel {
        HOME, WORK, MOBILE;
    }

    private PhoneLabel phoneLabel;
    private String number;

    /**
     * Initialization of phone number.
     *
     * @param phoneLabel the phone label.
     * @param number     the phone number.
     */
    public PhoneNumber(final PhoneLabel phoneLabel, final String number) {
        this.phoneLabel = phoneLabel;
        this.number = number;
    }

}
