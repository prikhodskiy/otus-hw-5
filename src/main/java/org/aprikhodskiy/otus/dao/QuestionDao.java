package org.aprikhodskiy.otus.dao;

import org.aprikhodskiy.otus.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
