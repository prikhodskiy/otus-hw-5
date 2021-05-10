package org.aprikhodskiy.otus.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс Question")
class QuestionTest {
    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Question newQuestoin = new Question("qText", 4, "qAnswer");

        assertThat(newQuestoin)
                .hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("text", "qText")
                .hasFieldOrPropertyWithValue("answer", "qAnswer")
                .hasFieldOrPropertyWithValue("order", 4);
    }
}
