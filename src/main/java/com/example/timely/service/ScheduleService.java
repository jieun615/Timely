package com.example.timely.service;

import com.example.timely.dto.ScheduleRequestDto;
import com.example.timely.dto.ScheduleResponseDto;
import com.example.timely.entity.Schedule;
import com.example.timely.exception.ScheduleNotFoundException;
import com.example.timely.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    public final ScheduleRepository scheduleRepository;

    //일정 생성
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.save(new Schedule(scheduleRequestDto));
        return new ScheduleRequestDto(schedule);
    }

    //전체 일정 조회
    @Transactional
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    //특정 일정 조회
    @Transactional
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        return new ScheduleResponseDto(schedule);
    }

    // 일정 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        schedule.update(requestDto);
        return new ScheduleResponseDto(schedule);
    }

    // 일정 삭제
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        scheduleRepository.delete(schedule);
    }
}
