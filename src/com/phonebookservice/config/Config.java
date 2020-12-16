package com.phonebookservice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.phonebookservice.exception.InternalServerException;

public final class Config {
    private static final Properties PROP = new Properties();
    private static Config singleton;

    public enum ConfigKey {
        FILE_PATH("phonebook.contact.filename");

        private String key;

        ConfigKey(final String key) {
            this.key = key;
        }

        /**
         *
         * @return key.
         */
        public String getKey() {
            return key;
        }
    }

    /**
     * config instance.
     *
     * @return config
     */
    public static Config getInstance() {
        if (singleton == null) {
            singleton = new Config();
        }

        return singleton;
    }

    private Config() {
        final InputStream input = getClass().getClassLoader()
                .getResourceAsStream("config.properties");
        try {
            PROP.load(input);
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
    }

    /**
     * get property of specific key.
     *
     * @param key the key.
     * @return value.
     */
    public static String get(final String key) {
        return PROP.getProperty(key);
    }

}
