package com.phonebookservice.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.model.Contact;
import com.phonebookservice.server.ContactConverter;
import com.phonebookservice.util.CollectionUtility;
import com.phonebookservice.util.ErrorCode;
import com.phonebookservice.util.ErrorMessages;
import com.phonebookservice.util.StringUtility;

public class ContactsFileParser implements IContactsParser {
    private static final String ENCODING = "UTF-8";
    private final String fileName;

    /**
     * Initialization of file parser.
     *
     * @param fileName the file name.
     */
    public ContactsFileParser(final String fileName) {
        if (StringUtility.isNullOrEmptyString(fileName)) {
            throw new InternalServerException(
                    ErrorMessages.ERROR_FILENAME_IS_NULL_OR_EMPTY,
                    ErrorCode.ERROR_FILENAME_IS_NULL_OR_EMPTY);
        }
        this.fileName = fileName;
    }

    @Override
    public final Collection<Contact> readContacts() {
        final List<Contact> contacts = new ArrayList<>();

        try {
            final File file = new File(this.fileName);
            final List<String> lines = FileUtils.readLines(
                    file, ContactsFileParser.ENCODING);

            for (String line : lines) {
                contacts.add(
                        ContactConverter.toContact(line));
            }
        } catch (IOException e) {
            throw new InternalServerException(e);
        }

        return contacts;
    }

    @Override
    public final void writeContacts(
            final Collection<Contact> contacts) {
        Writer fileWriter = null;

        try {
            fileWriter = new FileWriter(this.fileName,
                    false);

            if (CollectionUtility
                    .isNullOrEmptyList(contacts)) {
                return;
            }

            for (final Contact contact : contacts) {
                fileWriter.write(
                        ContactConverter.toString(contact));
                fileWriter.write(System
                        .getProperty("line.separator"));
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
}
