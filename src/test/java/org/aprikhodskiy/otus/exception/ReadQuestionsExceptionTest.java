package org.aprikhodskiy.otus.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Класс ReadQuestionsException")
public class ReadQuestionsExceptionTest {

    @DisplayName("корректно создается исключение")
    @Test
    void exceptionTest(){
        Throwable exception = assertThrows(ReadQuestionsException.class, () -> {
            throw new ReadQuestionsException("Read file exception");
        });

        assertEquals("Read file exception", exception.getMessage());
    }
}
