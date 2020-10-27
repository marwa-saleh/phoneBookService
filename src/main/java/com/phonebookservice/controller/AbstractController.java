package main.java.com.phonebookservice.controller;

import main.java.com.phonebookservice.model.Model;
import main.java.com.phonebookservice.server.DBIf;

public abstract class AbstractController {

    /**
     * database the database interface.
     */
    private DBIf databse = null;

    /**
     * controller constructor.
     *
     * @param databseValue the database
     */
    public AbstractController(final DBIf databseValue) {
        this.databse = databseValue;
    }

    /**
     * create model.
     *
     * @param model the model
     */
    public abstract void create(Model model);

    /**
     * get database.
     *
     * @return database.
     */
    public DBIf getDatabase() {
        return databse;
    }
}
