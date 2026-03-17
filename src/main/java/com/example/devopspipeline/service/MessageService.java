package com.example.devopspipeline.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String normalizeMessage(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Olá, pipeline acadêmico!";
        }
        return input.trim();
    }

    public String buildResponse(String input) {
        return "Deploy realizado com sucesso: " + normalizeMessage(input);
    }
}
