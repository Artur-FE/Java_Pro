package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

@RestController
public class DataTimeController {

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public DateNow getLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateNow dateNow = new DateNow(
                now.getYear(),
                now.getMonth(),
                now.getDayOfWeek(),
                now.getHour(),
                now.getMinute(),
                now.getSecond() );

        return dateNow;
    }
}
