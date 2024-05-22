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

@RestController
public class ElectionController {
    private final ElectionService electionService;
    private final IJavaToJSONConverter javaToJSONConverter;

    @Autowired
    public ElectionController(ElectionService electionService, IJavaToJSONConverter javaToJSONConverter) {
        this.electionService = electionService;
        this.javaToJSONConverter = javaToJSONConverter;
    }

    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry(@RequestParam String countryName) {
        final List<TestResponse> electionsForCountry = electionService.getElectionsForCountry(countryName);
        return javaToJSONConverter.convertJavaToJSON(electionsForCountry);
    }
}
