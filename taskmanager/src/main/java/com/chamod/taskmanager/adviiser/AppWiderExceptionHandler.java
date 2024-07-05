package com.chamod.taskmanager.adviiser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chamod.taskmanager.exception.EntryNotFoundException;
import com.chamod.taskmanager.util.StandardResponse;

@RestControllerAdvice
public class AppWiderExceptionHandler {
 @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(404,e.getMessage(),e),
                HttpStatus.NOT_FOUND
        );
    }
}
