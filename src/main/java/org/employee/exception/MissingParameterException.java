package org.employee.exception;

import org.springframework.http.HttpStatus;

public class MissingParameterException extends RuntimeException{

    private String message;
    private HttpStatus status;


}
