package com.election.reminders.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/test")
    public String index() {
        return "Hello World!";
    }

}