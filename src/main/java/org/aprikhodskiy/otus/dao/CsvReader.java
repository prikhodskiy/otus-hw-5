package org.aprikhodskiy.otus.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.aprikhodskiy.otus.exception.ReadQuestionsException;

import java.io.IOException;
import java.util.List;

@Component
public class CsvReader {

    @Value("${exam.questions.file.name}")
    Resource resourceFile;

    public List<CsvQuestionItem> readFile() {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            ObjectReader reader = mapper.readerFor(CsvQuestionItem.class).with(bootstrapSchema);
            MappingIterator<CsvQuestionItem> readValues = reader.readValues(resourceFile.getInputStream());
            return readValues.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReadQuestionsException(e.getMessage());
        }
    }
}
