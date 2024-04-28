package com.election.reminders.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.jr.ob.JSON;

@RestController
public class HelloController {
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/test")
    public String index() {
        String json = null;
        try {
            json = JSON.std.with(JSON.Feature.PRETTY_PRINT_OUTPUT)
                    .composeString()
                    .startObject()
                    .put("test", "testString")
                    .put("test2", 1)
                    .end()
                    .finish();
        } catch (Exception e) {
            System.out.println("Exception in GET request " + e.getMessage());
        }
        return json;
    }

}