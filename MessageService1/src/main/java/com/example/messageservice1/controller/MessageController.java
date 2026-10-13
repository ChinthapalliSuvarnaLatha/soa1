package com.example.messageservice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/msg")
    public String message() {
        return "Hello from Message Service 1";
    }

}