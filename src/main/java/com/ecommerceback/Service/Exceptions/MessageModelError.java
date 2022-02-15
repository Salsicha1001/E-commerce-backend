package com.ecommerceback.Service.Exceptions;

public class MessageModelError {

    private String message;

    public MessageModelError() {
    }

    public MessageModelError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
