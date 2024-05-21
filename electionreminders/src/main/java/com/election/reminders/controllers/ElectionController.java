package com.election.reminders.controllers;

import java.util.List;

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
    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry(@RequestParam String countryName) {
        // Should Election Service and Java Converter be beans?
        final List<TestResponse> electionsForCountry = new ElectionService().getElectionsForCountry(countryName);
        final IJavaToJSONConverter javaToJSONConveter = new JacksonJavaToJSONConverter();
        return javaToJSONConveter.convertJavaToJSON(electionsForCountry);
    }
}
