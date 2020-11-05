package com.phonebookservice.controller;

import java.util.HashMap;
import java.util.List;

import com.phonebookservice.dispatcher.QueryParamType;
import com.phonebookservice.dispatcher.QueryParam;
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
     * get list of models based on filters.
     *
     * @param paramValues the hashmap of query params.
     * @return list of models.
     */
    protected abstract List<T> getAll(
            HashMap<QueryParamType, QueryParam> paramValues);

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
    protected IDataAccessAdapter<T> getDatabase() {
        return database;
    }
}
