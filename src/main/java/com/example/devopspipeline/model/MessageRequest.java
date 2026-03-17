package com.example.devopspipeline.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MessageRequest {

    @NotBlank(message = "A mensagem não pode estar vazia")
    @Size(max = 120, message = "A mensagem deve ter no máximo 120 caracteres")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
