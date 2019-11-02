package com.zenika.catalogservice.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Throwable cause){
        super(cause);
    }

    public ProductNotFoundException( String message, Throwable cause){
        super(message, cause);
    }
}
