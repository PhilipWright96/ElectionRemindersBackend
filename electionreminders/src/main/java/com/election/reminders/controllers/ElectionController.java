package com.election.reminders.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import com.election.reminders.services.ElectionService;
import com.election.reminders.utils.IJavaToJSONConverter;

@RestController
public class ElectionController {
    private final ElectionService electionService;
    private final IJavaToJSONConverter javaToJSONConverter;
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    public ElectionController(ElectionService electionService, IJavaToJSONConverter javaToJSONConverter) {
        this.electionService = electionService;
        this.javaToJSONConverter = javaToJSONConverter;
    }

    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry(@RequestParam String countryName) {
        logger.info("Returning elections for " + countryName);
        final List<ElectionInformationDto> electionsForCountry = electionService.getElectionsForCountry(countryName);
        return javaToJSONConverter.convertJavaToJSON(electionsForCountry);
    }
}
