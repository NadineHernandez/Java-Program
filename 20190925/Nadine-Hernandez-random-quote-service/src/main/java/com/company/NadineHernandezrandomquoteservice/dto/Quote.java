package com.company.NadineHernandezrandomquoteservice.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quote {
    private String myQuote;

    public String getMyQuote() {
        return myQuote;
    }

    public void setMyQuote(String myQuote) {
        this.myQuote = myQuote;
    }

    public String getRandomQuote(){
        List<String> quotes = new ArrayList<>();
        String q1 = "To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. - Grace Hopper";
        String q2 = "Programs must be written for people to read, and only incidentally for machines to execute. - Hal Ableson";
        String q3 = "Don't call me the mother of the internet. - Radia Perlman";
        String q4 = "When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. - Margaret Hamilton";
        String q5 = "Machines take me by surprise with great frequency. - Alan Turing";
        String q6 = "The function of good software is to make the complex appear simple. - Grady Booch";
        String q7 = "An API that isn't comprehensible isn't usable. - James Gosling";
        String q8 = "I'm not a great programmer; I'm just a good programmer with great habits. - Martin Fowler";
        quotes.add(q1);
        quotes.add(q2);
        quotes.add(q3);
        quotes.add(q4);
        quotes.add(q5);
        quotes.add(q6);
        quotes.add(q7);
        quotes.add(q8);

        Random random = new Random();

        int num = random.nextInt(8);

        this.setMyQuote(quotes.get(num));

        return this.getMyQuote();
    }

}
