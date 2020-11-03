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
     * get model by id.
     *
     * @param modelId the model id.
     * @return model.
     */
    protected abstract T get(Long modelId);

    /**
     * create model.
     *
     * @param model the model.
     */
    protected abstract void create(T model);

    /**
     * update model.
     *
     * @param modelId the model id.
     * @param model   the changed model.
     *
     * @return model the updated model.
     */
    protected abstract T update(Long modelId, T model);

    /**
     * delete model.
     *
     * @param modelId the model id.
     */
    protected abstract void delete(Long modelId);

    /**
     * get database.
     *
     * @return database.
     */
    protected IDataAccessAdapter getDatabase() {
        return database;
    }
}
