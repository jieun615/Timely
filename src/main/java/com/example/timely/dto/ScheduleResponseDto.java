package com.example.timely.dto;

import com.example.timely.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String password;
    private String title;
    private String task;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.password = schedule.getPassword();
        this.title = schedule.getTitle();
        this.task = schedule.getTask();
    }
}
