package com.example.timely.controller;

import com.example.timely.dto.ScheduleRequestDto;
import com.example.timely.dto.ScheduleResponseDto;
import com.example.timely.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody @Validated ScheduleRequestDto scheduleRequestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(scheduleRequestDto);
        return ResponseEntity.ok(scheduleResponseDto);
    }

    //전체 일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        List<ScheduleResponseDto> scheduleResponseDtos = scheduleService.getAllSchedules();
        return ResponseEntity.ok(scheduleResponseDtos);
    }

    //특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.getSchedule(id);
        return ResponseEntity.ok(scheduleResponseDto);
    }

    //일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody @Validated ScheduleRequestDto scheduleRequestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id, scheduleRequestDto);
        return ResponseEntity.ok(updateSchedule);
    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
