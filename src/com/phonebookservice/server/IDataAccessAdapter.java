package com.phonebookservice.server;

import com.phonebookservice.model.Model;

public interface IDataAccessAdapter<T extends Model> {

    /**
     * create contact.
     *
     * @param model the model
     */
    void create(T model);
}
