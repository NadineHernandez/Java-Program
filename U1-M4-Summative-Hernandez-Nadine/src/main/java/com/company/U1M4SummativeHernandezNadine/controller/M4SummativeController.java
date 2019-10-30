package com.company.U1M4SummativeHernandezNadine.controller;

import com.company.U1M4SummativeHernandezNadine.models.Answer;
import com.company.U1M4SummativeHernandezNadine.models.Definition;
import com.company.U1M4SummativeHernandezNadine.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class M4SummativeController {
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    //200 response
    @ResponseStatus(HttpStatus.OK)
    public Quote retrieveQuote(){
        //instantiate quote object
        Quote quote = new Quote();
        //return the quote object with the random quote assigned
        //by the randomQuote method
        return quote.randomQuote();
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    //200 response
    @ResponseStatus(HttpStatus.OK)
    public Definition retrieveWord(){
        //instantiate definition object
        Definition definition = new Definition();
        //return the definition object with the random definition assigned by
        //the randomDefinition method
        return definition.randomDefinition();
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    //200 response
    @ResponseStatus(HttpStatus.OK)
    public Answer retrieveMagicAnswer(@RequestBody String question){
        //instantiate answer object
        Answer answer = new Answer();
        //set answer object's question to submitted question
        answer.setQuestion(question);
        //set answer object's answer to a random answer using our random answer method
        answer.randomAnswer();
        return answer;
    }
}
