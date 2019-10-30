package com.company.NadineHernandezrandomquoteservice.controller;

import com.company.NadineHernandezrandomquoteservice.dto.Quote;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RandomQuoteServiceController {
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String quote(){
        Quote quote = new Quote();

        return quote.getRandomQuote();
    }
}
