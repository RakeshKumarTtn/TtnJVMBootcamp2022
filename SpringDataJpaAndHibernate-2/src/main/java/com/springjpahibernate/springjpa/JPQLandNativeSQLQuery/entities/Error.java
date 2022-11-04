package com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities;

import java.time.LocalDateTime;

//This Class for printing the USER_FRIENDLY message when an exception occurs
public class Error {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public Error(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
