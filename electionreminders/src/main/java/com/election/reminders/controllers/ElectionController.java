package com.election.reminders.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.responses.TestResponse;
import com.election.reminders.services.ElectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ElectionController {
    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry(@RequestParam String countryName) {
        // Should Election Service be a bean?
        final List<TestResponse> electionsForCountry = new ElectionService().getElectionsForCountry(countryName);
        final ObjectMapper objectMapper = new ObjectMapper();

        String json = null;

        try {
            json = objectMapper.writeValueAsString(electionsForCountry);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
