package com.example.timely.config;

import com.example.timely.exception.ScheduleNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<String> handleScheduleNotFoundException(ScheduleNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
