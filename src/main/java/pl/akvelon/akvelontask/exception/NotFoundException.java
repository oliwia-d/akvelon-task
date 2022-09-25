package pl.akvelon.akvelontask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "%s was not found";

    public NotFoundException(Class<?> type) {
        super(String.format(MESSAGE_FORMAT, type.getSimpleName()));
    }
}
