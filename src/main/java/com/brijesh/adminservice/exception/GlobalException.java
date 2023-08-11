package com.brijesh.adminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<?> resourseNotFoundException(AdminException adminException){
        String message = adminException.getMessage();
        Map<String, String> map = new HashMap<>();
        map.put("Message", message);
        map.put("Status", HttpStatus.NOT_FOUND.name());
        return new ResponseEntity(map, HttpStatus.NOT_FOUND);
    }
}
