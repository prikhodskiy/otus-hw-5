package org.aprikhodskiy.otus.service;

import org.aprikhodskiy.otus.domain.Question;

import java.util.List;

public interface ExamService {
    List<Question> getAllQuestions();

    void runExam();
}
