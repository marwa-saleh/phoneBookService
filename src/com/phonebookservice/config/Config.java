package com.phonebookservice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * configuration class that will will load all the properties keys and values
 * from config file.
 *
 * @author marwa.saleh
 *
 */
public final class Config {
    private static final Properties PROP = new Properties();
    private static Config singleton;

    public enum ConfigKey {
        FILENAME_PATH("phonebook.contact.filename");

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
     * @throws IOException
     */
    public static Config getInstance() throws IOException {
        if (singleton == null) {
            singleton = new Config();
        }

        return singleton;
    }

    private Config() throws IOException {
        final InputStream input = getClass().getClassLoader()
                .getResourceAsStream("config.properties");
        try {
            PROP.load(input);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    /**
     * get property of specific key.
     *
     * @param key the key.
     * @return value.
     */
    public String get(final String key) {
        return PROP.getProperty(key);
    }

}
