package com.sys.empman.common.exception;

public class ValidationFaildException extends RuntimeException{

    public ValidationFaildException(String message) {
        super("ERROR : " + message);
    }

}
