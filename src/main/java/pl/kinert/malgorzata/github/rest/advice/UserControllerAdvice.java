package pl.kinert.malgorzata.github.rest.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import pl.kinert.malgorzata.github.rest.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.net.URISyntaxException;
import java.util.Arrays;

@RestControllerAdvice
public class UserControllerAdvice {

    public static final String PL_KINERT = "pl.kinert";
    public static final String USER_NOT_FOUND = "User not found";

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFoundHandler(HttpClientErrorException.NotFound ex) {
        return ErrorResponse.builder()
                .message(USER_NOT_FOUND)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse divisionByZeroHandler(ArithmeticException ex) {
        return getInternalServerErrorResponse(ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse illegalArgumentHandler(IllegalArgumentException ex) {
        return getInternalServerErrorResponse(ex);
    }

    @ExceptionHandler(URISyntaxException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse uriSyntaxExceptionHandler(URISyntaxException ex) {
        return getInternalServerErrorResponse(ex);
    }

    private ErrorResponse getInternalServerErrorResponse(Exception ex) {
        return ErrorResponse.builder()
                .message(getExceptionMessage(ex))
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    private String getExceptionMessage(Exception ex) {
        return getPackageAndClassFromStackTrace(ex) + ": " + ex.getMessage();
    }

    private StackTraceElement getPackageAndClassFromStackTrace(Exception ex){
        return Arrays.stream(ex.getStackTrace())
                .filter(line -> line.toString().startsWith(PL_KINERT))
                .findFirst()
                .get();
    }
}