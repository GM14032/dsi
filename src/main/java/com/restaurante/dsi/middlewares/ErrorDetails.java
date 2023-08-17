package com.restaurante.dsi.middlewares;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter @Getter @JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {
    private int status;
    private String error;
    private String message;
    private String path;
    private Errors[] errors;
    @Setter @Getter @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Errors {
        private String field;
        private String defaultMessage;
        private String code;
        public Errors(String field, String defaultMessage, String code) {
            this.field = field;
            this.defaultMessage = defaultMessage;
            this.code = code;
        }
    }
    public ErrorDetails() {
       this.errors = new Errors[]{};
    }
}