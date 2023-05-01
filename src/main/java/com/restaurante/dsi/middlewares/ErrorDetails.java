package com.restaurante.dsi.middlewares;

import lombok.*;

@Setter @Getter
public class ErrorDetails {
    private int status;
    private String error;
    private String message;
    private String path;
    private Errors[] errors;
    @Setter @Getter
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