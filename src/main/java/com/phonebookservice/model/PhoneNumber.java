package main.java.com.phonebookservice.model;

public class PhoneNumber {
    private String label;
    private String number;

    /**
     * phone number constructor.
     *
     * @param label  the label.
     * @param number the phone number.
     */
    public PhoneNumber(final String label, final String number) {
        super();
        this.label = label;
        this.number = number;
    }

}
