package com.phonebookservice.server;

import com.phonebookservice.model.Model;

public interface IDataAccessAdapter<T extends Model> {

    /**
     * get model.
     *
     * @param modelId the model id.
     *
     * @return model the model.
     */
    T get(Long modelId);

    /**
     * create model.
     *
     * @param model the model
     */
    void create(T model);

    /**
     * update model.
     *
     * @param modelId the model id.
     * @param model   the model.
     *
     * @return model the updated model.
     */
    T update(Long modelId, T model);

    /**
     * delete model.
     *
     * @param modelId the model id.
     */
    void delete(Long modelId);

    /**
     * save models.
     */
    void save();

}
