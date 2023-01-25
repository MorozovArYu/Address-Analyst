package com.gmail.morozowau.controller.exceptions;

public class NoSuchFileExtensionException extends RuntimeException {
    public NoSuchFileExtensionException(String message) {
        super(message);
    }
}
