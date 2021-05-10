package org.aprikhodskiy.otus.shell;

import lombok.RequiredArgsConstructor;
import org.aprikhodskiy.otus.service.ExamServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private String userName;

    private final MessageSource messageSource;

    private final ExamServiceImpl examService;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Добро пожаловать: %s", userName);
    }

    @ShellMethod(value = "Exam command", key = {"e", "exam"})
    @ShellMethodAvailability(value = "isExamAvailable")
    public void exam() {
        examService.runExam(this.userName);
    }

    private Availability isExamAvailable() {
        return userName == null ? Availability.unavailable("You are not logged in") : Availability.available();
    }
}
