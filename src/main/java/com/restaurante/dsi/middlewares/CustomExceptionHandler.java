package com.restaurante.dsi.middlewares;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@ControllerAdvice
public class CustomExceptionHandler  {
    @Autowired
    private HttpServletRequest request;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails handleValidationExceptions(MethodArgumentNotValidException ex) {
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

    }