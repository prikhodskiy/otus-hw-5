package org.aprikhodskiy.otus.exception;

public class ReadQuestionsException extends RuntimeException{
    public ReadQuestionsException(String errorMessage){
        super(errorMessage);
    }
}
