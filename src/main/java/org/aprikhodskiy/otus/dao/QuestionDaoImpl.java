package org.aprikhodskiy.otus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aprikhodskiy.otus.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    CsvReader csvReader;

    @Override
    public List<Question> findAll() {
        return csvReader.readFile().stream()
                .map(c -> new Question(c.getText(), c.getOrder(), c.getAnswer()))
                .collect(Collectors.toList());
    }
}
