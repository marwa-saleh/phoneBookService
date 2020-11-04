package test.java.com.phonebookservice.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.exception.BadRequestException;
import com.phonebookservice.exception.InternalServerException;
import com.phonebookservice.exception.NotFoundException;

/**
 * @author marwa.saleh
 *
 */
public class TestHttpServiceException {
    private static final String TEST_ERROR_MESSAGE = "Test error message";
    private static final String TEST_ERROR_CODE = "TEST_ERROR_CODE";
    private static final String TEST_INTERNAL_ERROR_MESSAGE = "Error found";
    private static final String TEST_INTERNAL_ERROR_CODE = "ERROR_FOUND";
    private static final int TEST_BAD_REQUEST_STATUS_CODE = 400;
    private static final int TEST_NOT_FOUND_STATUS_CODE = 404;
    private static final int TEST_INTERNAL_SERVER_STATUS_CODE = 500;

    /**
     * test bad request exception.
     */
    @Test
    public void testBadRequestException() {
        final BadRequestException badRequestException = new BadRequestException(
                TEST_ERROR_MESSAGE, TEST_ERROR_CODE);

        Assertions.assertEquals(TEST_ERROR_MESSAGE,
                badRequestException.getMessage());
        Assertions.assertEquals(TEST_ERROR_CODE,
                badRequestException.getErrorCode());
        Assertions.assertEquals(TEST_BAD_REQUEST_STATUS_CODE,
                badRequestException.getStatusCode());
        Assertions.assertTrue(badRequestException.isClientException());
    }

    /**
     * test not found exception.
     */
    @Test
    public void testNotFoundException() {
        final NotFoundException badRequestException = new NotFoundException(
                TEST_ERROR_MESSAGE, TEST_ERROR_CODE);

        Assertions.assertEquals(TEST_ERROR_MESSAGE,
                badRequestException.getMessage());
        Assertions.assertEquals(TEST_ERROR_CODE,
                badRequestException.getErrorCode());
        Assertions.assertEquals(TEST_NOT_FOUND_STATUS_CODE,
                badRequestException.getStatusCode());
        Assertions.assertTrue(badRequestException.isClientException());
    }

    /**
     * test internal server exception.
     */
    @Test
    public void testInternalServerException() {
        final NullPointerException exception = new NullPointerException();
        final InternalServerException internalServerException //
                = new InternalServerException(exception);

        Assertions.assertEquals(TEST_INTERNAL_ERROR_MESSAGE,
                internalServerException.getMessage());
        Assertions.assertEquals(TEST_INTERNAL_ERROR_CODE,
                internalServerException.getErrorCode());
        Assertions.assertEquals(TEST_INTERNAL_SERVER_STATUS_CODE,
                internalServerException.getStatusCode());
        Assertions.assertFalse(internalServerException.isClientException());
        Assertions.assertEquals(exception, internalServerException.getCause());
    }
}
