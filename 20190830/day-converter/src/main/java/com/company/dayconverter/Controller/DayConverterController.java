package com.company.dayconverter.Controller;

import com.company.dayconverter.model.Day;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayConverterController {
    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.CREATED)
        public String convertDay(@PathVariable Integer dayNumber){
        if (dayNumber > 7 || dayNumber < 1){
            throw new IllegalArgumentException("Number must be from 1 to 7");
        }
        Day day = new Day();
        return day.convertDay(dayNumber);
    }
}
