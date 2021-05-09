package org.aprikhodskiy.otus.domain;

public class Question {
    private final String text;
    private final Integer order;
    private final String answer;

    public String getText() {
        return text;
    }

    public Integer getOrder() {
        return order;
    }

    public String getAnswer() {
        return answer;
    }

    public Question(String text, Integer order, String answer) {
        this.text = text;
        this.order = order;
        this.answer = answer;
    }
}
