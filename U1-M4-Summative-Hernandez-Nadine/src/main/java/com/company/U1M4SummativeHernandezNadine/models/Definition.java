package com.company.U1M4SummativeHernandezNadine.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Definition {
    private String word;
    private String definition;
    private static List<String> wordList = new ArrayList<>();
    private static HashMap<String, String> wordMap = new HashMap<>();

    //fill wordMap with all of our word/definition key value possibilities
    public static void fillMap(){
        Definition.getWordMap().put("vermillion", "of a vivid red to reddish-orange color");
        Definition.getWordMap().put("wonky", "turned or twisted toward one side");
        Definition.getWordMap().put("tenacious", "stubbornly unyielding");
        Definition.getWordMap().put("tangible", "perceptible by the senses, especially the sense of touch");
        Definition.getWordMap().put("rambunctious", "noisy and lacking in restraint or discipline");
        Definition.getWordMap().put("quixotic", "not sensible about practical matters");
        Definition.getWordMap().put("paradigm", "a standard or typical example");
        Definition.getWordMap().put("nostalgic", "unhappy about being away and longing for familiar things");
        Definition.getWordMap().put("misanthrope", "someone who dislikes people in general");
        Definition.getWordMap().put("melancholy", "a constitutional tendency to be gloomy and depressed");
        Definition.getWordMap().put("lethargic", "deficient in alertness or activity");

        Definition.getWordMap().forEach((k,v)->Definition.getWordList().add(k));
    }

    //randomly assign a word from word list and it's corresponding definition from the word Map using a
    //randomly generated index
    public Definition randomDefinition(){
        Definition.fillMap();
        Random random = new Random();
        int wordNum = random.nextInt(11)+1;
        //assign word
        this.setWord(Definition.getWordList().get(wordNum));
        //assign definition
        this.setDefinition(Definition.getWordMap().get(this.getWord()));
        //return the definition object we created
        return this;
    }

    //getters and setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public static List<String> getWordList() {
        return wordList;
    }

    public static void setWordList(List<String> wordList) {
        Definition.wordList = wordList;
    }

    public static HashMap<String, String> getWordMap() {
        return wordMap;
    }

    public static void setWordMap(HashMap<String, String> wordMap) {
        Definition.wordMap = wordMap;
    }
}
