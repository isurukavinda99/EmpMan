package com.sys.empman.common;

public class ValidationFaildException extends RuntimeException{

    public ValidationFaildException(String message) {
        super("ERROR : " + message);
    }

}
