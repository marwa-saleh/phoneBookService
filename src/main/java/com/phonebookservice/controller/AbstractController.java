package main.java.com.phonebookservice.controller;

import main.java.com.phonebookservice.model.Model;
import main.java.com.phonebookservice.server.DBIf;

public abstract class AbstractController {

    private DBIf databse = null;

    public AbstractController(final DBIf databse) {
        this.databse = databse;
    }

    public abstract void create(final Model model);

    public DBIf getDatabase() {
        return databse;
    }
}
