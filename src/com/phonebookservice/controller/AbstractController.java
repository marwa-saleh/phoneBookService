package com.phonebookservice.controller;

import com.phonebookservice.model.Model;
import com.phonebookservice.server.IDataAccessAdapter;

/**
 * abstract controller.
 *
 * @author Marwa Saleh
 * @param <T> model
 */
public abstract class AbstractController<T extends Model> {
    private final IDataAccessAdapter database;

    /**
     * Initialization of abstract controller.
     *
     * @param database the database
     */
    protected AbstractController(final IDataAccessAdapter database) {
        this.database = database;
    }

    /**
     * create model.
     *
     * @param model the model
     */
    protected abstract void create(T model);

    /**
     * get database.
     *
     * @return database.
     */
    protected IDataAccessAdapter getDatabase() {
        return database;
    }
}
