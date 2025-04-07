package com.example.timely.entity;

import com.example.timely.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column
    private String task;

    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.username = scheduleRequestDto.getUsername();
        this.password = scheduleRequestDto.getPassword();
        this.title = scheduleRequestDto.getTitle();
        this.task = scheduleRequestDto.getTask();
    }

    public void update(ScheduleRequestDto scheduleRequestDto) {
        this.username = scheduleRequestDto.getUsername();
        this.password = scheduleRequestDto.getPassword();
        this.title = scheduleRequestDto.getTitle();
        this.task = scheduleRequestDto.getTask();
    }
}
