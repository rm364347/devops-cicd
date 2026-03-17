package com.example.devopspipeline.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeployFlowFT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldProcessDeployFormSuccessfully() throws Exception {
        mockMvc.perform(post("/deploy")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("message", "release 2.0"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString(
                        "Deploy realizado com sucesso: release 2.0"
                )));
    }

    @Test
    void shouldRejectInvalidDeployForm() throws Exception {
        mockMvc.perform(post("/deploy")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("message", "   "))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString(
                        "Validação falhou. Corrija a mensagem e tente novamente."
                )));
    }
}
