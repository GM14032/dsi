package com.restaurante.dsi.middlewares;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@ControllerAdvice
public class CustomExceptionHandler {
    @Autowired
    private HttpServletRequest request;

    @PostMapping
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails handleValidationExceptions(MethodArgumentNotValidException ex) {
        if (!request.getMethod().equalsIgnoreCase("POST")) {
            //imprime el error en consola
            System.out.println(request.getMethod());
            return null;
        }
        System.out.println(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails();
        List<ErrorDetails.Errors> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            String code = error.getCode();
            errors.add(new ErrorDetails.Errors(field, defaultMessage, code));
        });
        errorDetails.setStatus(ex.getStatusCode().value());
        errorDetails.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorDetails.setMessage("Validation failed");
        errorDetails.setPath(request.getRequestURI());
        errorDetails.setErrors(errors.toArray(new ErrorDetails.Errors[0]));
        return errorDetails;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public static class DataIntegrityException extends RuntimeException {
        public DataIntegrityException(String message) {
            super(message);
        }
    }
    @ExceptionHandler(org.springframework.beans.TypeMismatchException.class)
    public ResponseEntity<ErrorDetails> handleTypeMismatchException(org.springframework.beans.TypeMismatchException ex) {

        ErrorDetails errorDetails = new ErrorDetails();
        if (ex.getRequiredType() == LocalDate.class) {
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorDetails.setMessage("Valor de parámetro no válido para las fechas. Utilice el formato yyyy-MM-dd.");
        errorDetails.setPath(request.getRequestURI());
        errorDetails.setErrors(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}