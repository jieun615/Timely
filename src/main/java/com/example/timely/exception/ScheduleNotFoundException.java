package com.example.timely.exception;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException(Long id) {
        super("일정을 찾을 수 없습니다. ID:" + id);
    }

}
