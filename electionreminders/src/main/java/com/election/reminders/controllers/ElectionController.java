package com.election.reminders.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.responses.TestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ElectionController {
    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry() {
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        TestResponse testResponse1 = new TestResponse();
        testResponse1.electionName = "Germany";

        TestResponse testResponse2 = new TestResponse();
        testResponse2.electionName = "France";

        try {
            json = objectMapper.writeValueAsString(Arrays.asList(testResponse1, testResponse2));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
