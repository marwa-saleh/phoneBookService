package test.java.com.phonebookservice.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.model.Contact;
import com.phonebookservice.server.FileDataAccessAdapter;
import com.phonebookservice.server.IDataAccessAdapter;

public class TestFileDataAccessAdapter {

    /**
     * test file data access adapter.
     */
    @Test
    public void testFileDataAccessAdapter() {
        final IDataAccessAdapter databaseMock = new FileDataAccessAdapter();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            databaseMock.create(new Contact());
        });
    }

}
