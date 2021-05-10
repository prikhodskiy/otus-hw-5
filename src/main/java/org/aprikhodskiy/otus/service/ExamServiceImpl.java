package org.aprikhodskiy.otus.service;

import org.aprikhodskiy.otus.dao.QuestionDao;
import org.aprikhodskiy.otus.domain.Question;
import org.aprikhodskiy.otus.domain.Student;
import org.aprikhodskiy.otus.exception.ReadQuestionsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Service
public class ExamServiceImpl implements ExamService {
    private final QuestionDao dao;

    private final MessageSource messageSource;

    int correctAnswersCounter = 0;

    private Student student;
    private final UserInput userInput;

    @Value("${exam.pass-rate}")
    private String passRate = "0";

    public ExamServiceImpl(QuestionDao dao, MessageSource messageSource, UserInput userInput) {
        this.dao = dao;
        this.messageSource = messageSource;
        this.userInput = userInput;
    }

    @Override
    public List<Question> getAllQuestions() {
        try {
            return dao.findAll();
        } catch (ReadQuestionsException e) {
            System.out.println("Read questions exception:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void runExam(String studentName) {
        this.student = new Student(studentName);
        for (Question q :
                dao.findAll()) {
            if (checkAnswer(q))
                correctAnswersCounter++;
            System.out.println("===============================================");
        }
        printResults();
    }

    private String getLocalizedMessage(String key) {
        return getLocalizedMessage(key, null);
    }

    private String getLocalizedMessage(String key, Object[] text) {
        return messageSource.getMessage(key, text, Locale.getDefault());
    }

    private boolean checkAnswer(Question question) {
        System.out.println();
        System.out.println("+++++++++++++++" + getLocalizedMessage("question") + " №: " + question.getOrder() + " ++++++++++++++++");
        System.out.println(question.getText());

        try {
            String studentAnswer = userInput.getAnswer();
            return studentAnswer.equals(question.getAnswer());
        } catch (IOException e) {
            System.out.println("Sorry. Something went wrong: " + e.getMessage());
            return false;
        }
    }


    private void printResults() {
        System.out.println();
        System.out.println(getLocalizedMessage("result.count", new Object[]{correctAnswersCounter}));
        System.out.println(
                correctAnswersCounter >= Integer.parseInt(passRate) ?
                        getLocalizedMessage("result.success") : getLocalizedMessage("result.fail", new String[]{student.getName()})
        );
    }
}
