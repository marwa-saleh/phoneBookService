package main.java.com.phonebookservice.model;

public class PhoneNumber {
    /**
     * phone label.
     */
    private String label;
    /**
     * social phone number.
     */
    private String phoneNumber;

    /**
     * phone number constructor.
     *
     * @param labelValue       the label.
     * @param phoneNumberValue the phone number.
     */
    public PhoneNumber(final String labelValue, final String phoneNumberValue) {
        super();
        this.label = labelValue;
        this.phoneNumber = phoneNumberValue;
    }

}
