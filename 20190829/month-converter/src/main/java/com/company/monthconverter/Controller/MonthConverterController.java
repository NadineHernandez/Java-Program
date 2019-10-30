package com.company.monthconverter.Controller;

import com.company.monthconverter.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterController {
    @RequestMapping(value="/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public String convertMonth(@PathVariable Integer monthNumber){
        Month month = new Month();
        return month.convertMonth(monthNumber);
    }
}
