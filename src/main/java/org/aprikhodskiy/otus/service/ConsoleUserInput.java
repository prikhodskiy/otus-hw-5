package org.aprikhodskiy.otus.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ConsoleUserInput implements UserInput {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getName() throws IOException {
        return reader.readLine();
    }

    @Override
    public String getAnswer() throws IOException {
        return reader.readLine();
    }
}
