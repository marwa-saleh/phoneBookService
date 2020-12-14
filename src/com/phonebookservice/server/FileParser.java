package com.phonebookservice.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.CollectionUtility;
import com.phonebookservice.util.MyArrayList;

public class FileParser implements ContactParser {
    private static final String ENCODING = "UTF-8";
    private String fileName = null;
    private MyArrayList<Contact> myContactList = null;
    private Map<String, Contact> myContactMap = null;

    /**
     * Initialization of file parser.
     *
     * @param myContactList
     * @param myContactMap
     */
    public FileParser(final MyArrayList<Contact> myContactList,
            final Map<String, Contact> myContactMap) {
        super();
        this.myContactList = myContactList;
        this.myContactMap = myContactMap;
        loadProperties();
    }

    private void loadProperties() {
        final Properties prop = new Properties();
        final InputStream input = getClass().getClassLoader()
                .getResourceAsStream("config.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new InternalServerException(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new InternalServerException(e);
                }
            }
        }

        this.fileName = prop.getProperty("phonebook.contact.filename");
    }

    @Override
    public final void readContact() {

        try {
            final File file = new File(this.fileName);
            final List<String> lines = FileUtils.readLines(file, ENCODING);

            for (String line : lines) {
                final String[] splitLine = line
                        .split(ContactConverter.SPLITTER);
                final String id = splitLine[ContactColumns.ID.getKey()];
                final Contact contact = ContactConverter
                        .convertStringToContact(splitLine);
                this.myContactList.add(contact);
                this.myContactMap.put(id, contact);
            }
        } catch (IOException e) {
            throw new InternalServerException(e);
        }

    }

    @Override
    public final void writeContact() {
        Writer fileWriter = null;

        try {
            fileWriter = new FileWriter(this.fileName, false);

            if (CollectionUtility.isNotNullOrEmptyList(this.myContactList)) {
                for (Contact contact : this.myContactList) {
                    fileWriter.write(ContactConverter.convertContactToString(
                            this.myContactMap, contact));
                    fileWriter.write(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            throw new InternalServerException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new InternalServerException(e);
                }
            }
        }
    }

    /**
     * get contact list.
     *
     * @return contact list.
     */
    public MyArrayList<Contact> getMyContactList() {
        return this.myContactList;
    }

    /**
     * get contact map.
     *
     * @return contact map
     */
    public Map<String, Contact> getMyContactMap() {
        return this.myContactMap;
    }

}
