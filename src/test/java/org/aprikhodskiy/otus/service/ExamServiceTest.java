package org.aprikhodskiy.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.aprikhodskiy.otus.dao.QuestionDao;
import org.aprikhodskiy.otus.domain.Question;
import org.springframework.context.MessageSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@DisplayName("Класс Question")
@ExtendWith(MockitoExtension.class)
class ExamServiceTest {

    @Mock
    private QuestionDao questionDao;

    @Mock
    private UserInput userInput;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private ExamServiceImpl examService;

    private Question testQ() {
        return new Question("Q text", 7, "Q answer");
    }

    private List<Question> testQuestions() {
        return Arrays.asList(
                new Question("q 1", 1, "answer 1"),
                new Question("q 2", 2, "answer 2"),
                new Question("q 3", 3, "answer 3"),
                testQ()
        );
    }

    private List<Question> simpleQuestions() {
        return Arrays.asList(
                new Question("q 1", 1, "yes"),
                new Question("q 2", 2, "yes")
        );
    }


    @DisplayName("получение всего списка вопросов")
    @Test
    void findAllTest() {
        given(questionDao.findAll()).willReturn(testQuestions());

        assertThat(examService.getAllQuestions())
                .isNotNull()
                .hasSize(4);
    }

    @DisplayName("Содержит определенный вопрос")
    @Test
    void containsQuestionTest() {
        given(questionDao.findAll()).willReturn(testQuestions());

        assertThat(examService.getAllQuestions())
                .anySatisfy(question -> question.getText().equals(testQ().getText()));

    }

    @DisplayName("результаты тестирования")
    @Test
    void examResultTest() throws IOException {
        given(questionDao.findAll()).willReturn(simpleQuestions());
//        given(userInput.getName()).willReturn("student");
        given(userInput.getAnswer()).willReturn("yes");
        given(messageSource.getMessage(anyString(),  any(), any())).willReturn("message");

        examService.runExam("student");

        assertEquals(2, examService.correctAnswersCounter);
    }
}
