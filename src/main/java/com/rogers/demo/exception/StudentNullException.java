package com.rogers.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentNullException extends RuntimeException{
    public StudentNullException(){
        super("Student can not be null");
    }
}
