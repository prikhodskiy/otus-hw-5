package org.aprikhodskiy.otus.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс Student")
class StudentTest {
    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Student newStudent = new Student("Jhon");
        assertThat(newStudent)
                .hasFieldOrPropertyWithValue("name", "Jhon")
                .hasNoNullFieldsOrProperties();

    }
}