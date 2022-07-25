package cesaugusto108.mongodb_spring.controller.resources.exceptions;

import cesaugusto108.mongodb_spring.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException objectNotFoundException,
                                                                 HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        StandardError standardError = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Object not " +
                "found.", objectNotFoundException.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
