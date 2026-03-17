package com.example.devopspipeline.controller;

import com.example.devopspipeline.model.MessageRequest;
import com.example.devopspipeline.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final MessageService messageService;

    public WebController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messageRequest", new MessageRequest());
        model.addAttribute("result", messageService.buildResponse(null));
        return "index";
    }

    @PostMapping("/deploy")
    public String deploy(@Valid MessageRequest messageRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("result", "Validação falhou. Corrija a mensagem e tente novamente.");
            return "index";
        }
        model.addAttribute("result", messageService.buildResponse(messageRequest.getMessage()));
        return "index";
    }
}
