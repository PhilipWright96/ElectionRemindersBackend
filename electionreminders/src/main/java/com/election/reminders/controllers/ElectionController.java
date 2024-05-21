package com.election.reminders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.jackson.responses.TestResponse;
import com.election.reminders.services.ElectionService;
import com.election.reminders.utils.IJavaToJSONConverter;
import com.election.reminders.utils.JacksonJavaToJSONConverter;

@RestController
public class ElectionController {
    private final ElectionService electionService;

    @Autowired
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry(@RequestParam String countryName) {
        // Should Election Service and Java Converter be beans?
        final List<TestResponse> electionsForCountry = electionService.getElectionsForCountry(countryName);
        final IJavaToJSONConverter javaToJSONConverter = new JacksonJavaToJSONConverter();
        return javaToJSONConverter.convertJavaToJSON(electionsForCountry);
    }
}
