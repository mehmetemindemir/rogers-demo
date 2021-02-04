package com.rogers.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException  extends RuntimeException{
    public StudentNotFoundException(Long Id){
        super("Student "+Id+" not found");
    }
}
