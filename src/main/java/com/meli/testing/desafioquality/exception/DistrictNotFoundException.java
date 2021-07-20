package com.meli.testing.desafioquality.exception;

public class DistrictNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DistrictNotFoundException(String message) {
        super(message);
    }
}
