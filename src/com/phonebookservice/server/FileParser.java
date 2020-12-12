package com.phonebookservice.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.util.CollectionUtility;
import com.phonebookservice.util.MyArrayList;

public class FileParser implements ContactParser {
    private static final String FILE_NAME = "src/com/"
            + "phonebookservice/server/FileDatabaseClient";
    private static final String ENCODING = "UTF-8";
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
    }

    @Override
    public final void readContact() {

        try {
            final File file = new File(FILE_NAME);
            final List<String> lines = FileUtils.readLines(file, ENCODING);

            for (String line : lines) {
                final String[] splitLine = line
                        .split(ContactConverter.SPLITTER);
                final String id = splitLine[0];
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
        try {
            final Writer fileWriter = new FileWriter(FILE_NAME, false);

            if (CollectionUtility.isNotNullOrEmptyList(this.myContactList)) {
                for (Contact contact : this.myContactList) {
                    fileWriter.write(ContactConverter.convertContactToString(
                            this.myContactMap, contact));
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            throw new InternalServerException(e);
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
