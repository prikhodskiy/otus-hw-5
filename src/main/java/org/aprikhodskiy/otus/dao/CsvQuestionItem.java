package org.aprikhodskiy.otus.dao;

public class CsvQuestionItem {

    private String text;
    private Integer order;
    private String answer;

    public void setText(String text) {
        this.text = text;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getText() {
        return text;
    }

    public Integer getOrder() {
        return order;
    }

    public String getAnswer() {
        return answer;
    }

    public CsvQuestionItem() {
    }

    public CsvQuestionItem(Integer order, String text, String answer) {
        this.text = text;
        this.order = order;
        this.answer = answer;
    }
}
