package org.aprikhodskiy.otus;

import org.aprikhodskiy.otus.service.ExamService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Hw5Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Hw5Application.class, args);
		ExamService service = context.getBean(ExamService.class);
		service.runExam();
	}

}
