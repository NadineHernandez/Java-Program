package com.company.NadineHernandezmagiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallController {
    private List<String> magicList = new ArrayList<>();

    private Random random = new Random();

    public MagicEightBallController(){
        magicList.add("No");
        magicList.add("Yes");
        magicList.add("Looking cloudy");
        magicList.add("Not sure");
        magicList.add("Absolutely!");
        magicList.add("Ask again");
        magicList.add("Ummm");
        magicList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getMagicEightBallAnswer(){
        int answer = random.nextInt(8);
        return magicList.get(answer);
    }
}
