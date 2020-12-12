package com.phonebookservice.server;

public enum ContactColumns {

    ID(0), LAST_NAME(1), FIRST_NAME(2), STREET(3), CITY(4), PHONE_NUMBER(5);

    private Integer key;

    ContactColumns(final Integer key) {

        this.setKey(key);
    }

    /**
     * get key.
     *
     * @return number.
     */
    public Integer getKey() {

        return key;
    }

    private void setKey(final Integer key) {

        this.key = key;
    }
}
