package com.phonebookservice.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.CollectionUtility;
import com.phonebookservice.util.MyArrayList;

/**
 * file data access adapter.
 *
 * @author Marwa Saleh
 */
public final class FileDataAccessAdapter
        implements IDataAccessAdapter<Contact> {
    private static FileDataAccessAdapter singleton;
    private static final String FILE_NAME = "D:\\phoneBookService\\src\\com\\"
            + "phonebookservice\\server\\FileDatabaseClient";
    private static final String ENCODING = "UTF-8";
    private MyArrayList<Contact> myContactList //
            = new MyArrayList<Contact>();
    private BiMap<String, Contact> myContactMap = HashBiMap.create();

    /**
     * Initialization of file data access adapter.
     */
    private FileDataAccessAdapter() {
        load();
    }

    /**
     * Get instance of file data access adapter.
     *
     * @return file data access adapter.
     */
    public static FileDataAccessAdapter getInstance() {
        if (singleton == null) {
            singleton = new FileDataAccessAdapter();
        }

        return singleton;
    }

    /**
     * get contact.
     *
     * @param contactId the contact id.
     *
     * @return contact the contact.
     */
    @Override
    public Contact get(final Long contactId) {
        if (contactId == null) {
            return null;
        }

        return this.myContactMap.get(contactId.toString());
    }

    /**
     * create contact.
     *
     * @param contact the contact.
     */
    @Override
    public void create(final Contact contact) {
        throw new UnsupportedOperationException();
    }

    /**
     * update contact.
     *
     * @param contactId the contact id.
     * @param contact   the contact.
     *
     * @return contact.
     */
    @Override
    public Contact update(final Long contactId, final Contact contact) {
        throw new UnsupportedOperationException();
    }

    /**
     * delete contact.
     *
     * @param contactId the contact id.
     */
    @Override
    public void delete(final Long contactId) {
        throw new UnsupportedOperationException();
    }

    /**
     * save contacts.
     *
     * @throws IOException
     */
    @Override
    public void save() {
        // TODO to be done every time duration
        try {
            final Writer fileWriter = new FileWriter(FILE_NAME, false);

            if (CollectionUtility.isNotNullOrEmptyList(this.myContactList)) {
                for (Contact contact : this.myContactList) {
                    fileWriter.write(ContactConverter
                            .mapContactToString(this.myContactMap, contact));
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            throw new InternalServerException(e);
        }
    }

    /**
     * load contacts.
     *
     * @throws IOException
     */
    private void load() {
        try {
            final File file = new File(FILE_NAME);
            final List<String> lines = FileUtils.readLines(file, ENCODING);

            for (String line : lines) {
                final String[] splitLine = line.split(",");
                final String id = splitLine[0];
                final Contact contact = ContactConverter
                        .mapStringToContact(splitLine);
                this.myContactList.add(contact);
                this.myContactMap.put(id, contact);
            }
        } catch (IOException e) {
            throw new InternalServerException(e);
        }
    }
}
