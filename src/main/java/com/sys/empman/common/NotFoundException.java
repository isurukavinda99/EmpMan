package com.sys.empman.common;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super("NOT_FOUND_ERROR : " + message);
    }
}
