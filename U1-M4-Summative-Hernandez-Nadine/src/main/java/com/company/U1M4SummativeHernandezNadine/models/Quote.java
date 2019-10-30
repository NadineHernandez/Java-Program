package com.company.U1M4SummativeHernandezNadine.models;

import java.util.*;

public class Quote {
    private String author;
    private String quote;
    private static List<String> authorList = new ArrayList<>();
    private static HashMap<String, String> quoteMap = new HashMap<>();

    //fill quoteMap with all of our possible key value pairs of authors and quotes
    public static void fillMap(){
        Quote.getQuoteMap().put("Dr. Seuss", "Don't cry because it's over, smile because it happened.");
        Quote.getQuoteMap().put("Mother Teresa ", "If you judge people, you have no time to love them.");
        Quote.getQuoteMap().put("Mae West", "You only live once, but if you do it right, once is enough.");
        Quote.getQuoteMap().put("Mahatma Gandhi", "Be the change that you wish to see in the world.");
        Quote.getQuoteMap().put("Robert Frost", "In three words I can sum up everything I've learned about life: it goes on.");
        Quote.getQuoteMap().put("Eleanor Roosevelt", "No one can make you feel inferior without your consent.");
        Quote.getQuoteMap().put("Mark Twain", "If you tell the truth, you don't have to remember anything.");
        Quote.getQuoteMap().put("Oscar Wilde", "Always forgive your enemies; nothing annoys them so much.");
        Quote.getQuoteMap().put("Stephen Chbosky", "We accept the love we think we deserve.");
        Quote.getQuoteMap().put("Coco Chanel", "The most courageous act is still to think for yourself. Aloud.");
        Quote.getQuoteMap().put("Ralph Waldo Emerson", "A great man is always willing to be little.");

        //fill author list with only keys
        Quote.getQuoteMap().forEach((k,v)->Quote.getAuthorList().add(k));
    }

    //randomly assign author from author list and corresponding quote from the quote map
    //using a randomly generate index
    public Quote randomQuote(){
        Quote.fillMap();
        Random random = new Random();
        int quoteNum = random.nextInt(11)+1;
        //assign author
        this.setAuthor(Quote.getAuthorList().get(quoteNum));
        //assign quote
        this.setQuote(Quote.getQuoteMap().get(this.getAuthor()));
        //return quote object we created
        return this;
    }

    //getters and setters
    public static List<String> getAuthorList() {
        return Quote.authorList;
    }

    public static void setAuthorList(List<String> authorList) {
        Quote.authorList = authorList;
    }

    public static HashMap<String, String> getQuoteMap() {
        return Quote.quoteMap;
    }

    public static void setQuoteMap(HashMap<String, String> quoteMap) {
        Quote.quoteMap = quoteMap;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
