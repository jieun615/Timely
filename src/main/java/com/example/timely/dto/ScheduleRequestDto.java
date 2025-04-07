package com.example.timely.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ScheduleRequestDto {

    private String username;
    private String password;
    private String title;
    private String task;
}
