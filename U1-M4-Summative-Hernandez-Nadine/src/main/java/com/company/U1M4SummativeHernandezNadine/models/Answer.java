package com.company.U1M4SummativeHernandezNadine.models;

import javax.validation.constraints.NotEmpty;
import java.util.Random;

public class Answer {
    @NotEmpty(message = "You must provide a question.")
    private String question;
    private String answer;
    //Array containing all possible magic 8 ball answers
    private static String[] answerArr = {
            "It is certain",
            "As I see it, yes",
            "Reply hazy, try again",
            "Don't count on it",
            "It is decidedly so",
            "Most likely",
            "Ask again later",
            "My reply is no",
    };

    //this method assigns answer a random value from the answer array using a randomly generated index
    public void randomAnswer() {
        Random random = new Random();
        int answerNum = random.nextInt(8);
        this.setAnswer(Answer.getAnswerArr()[answerNum]);
    }

    //getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static String[] getAnswerArr() {
        return answerArr;
    }

}
