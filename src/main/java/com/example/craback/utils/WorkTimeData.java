package com.example.craback.utils;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkTimeData {

    private LocalDate date;
    private Long duration;
}
