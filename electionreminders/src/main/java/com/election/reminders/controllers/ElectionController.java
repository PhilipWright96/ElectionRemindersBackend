package com.election.reminders.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.jr.ob.JSON;

@RestController
public class ElectionController {
    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry() {
        String json = null;
        try {
            json = JSON.std.with(JSON.Feature.PRETTY_PRINT_OUTPUT)
                    .composeString()
                    .startObject()
                    .put("electionName", "a")
                    .end()
                    .finish();
        } catch (Exception e) {
            System.out.println("Exception in GET request " + e.getMessage());
        }
        return json;
    }
}
