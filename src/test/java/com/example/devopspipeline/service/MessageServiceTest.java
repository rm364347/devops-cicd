package com.example.devopspipeline.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageServiceTest {

    private final MessageService messageService = new MessageService();

    @Test
    void shouldReturnDefaultMessageWhenInputIsNull() {
        assertEquals("Olá, pipeline acadêmico!", messageService.normalizeMessage(null));
    }

    @Test
    void shouldTrimInputMessage() {
        assertEquals("release 1.0", messageService.normalizeMessage("  release 1.0  "));
    }

    @Test
    void shouldBuildSuccessResponse() {
        assertEquals("Deploy realizado com sucesso: produção", messageService.buildResponse("produção"));
    }
}
