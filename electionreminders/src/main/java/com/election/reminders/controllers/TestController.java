package com.election.reminders.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.jr.ob.JSON;

@RestController
public class TestController {
    private static final String FRONT_END_URL = "http://localhost:8100";

    @CrossOrigin(origins = FRONT_END_URL)
    @GetMapping("/test")
    public String getTestJSON() {
        String json = null;
        try {
            json = JSON.std.with(JSON.Feature.PRETTY_PRINT_OUTPUT)
                    .composeString()
                    .startObject()
                    .put("test", "testString")
                    .end()
                    .finish();
        } catch (Exception e) {
            System.out.println("Exception in GET request " + e.getMessage());
        }
        return json;
    }

}