package com.election.reminders.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.jackson.requests.TestRequest;
import com.election.reminders.persistence.ElectionInformation;
import com.election.reminders.repositories.ElectionRepository;
import com.fasterxml.jackson.jr.ob.JSON;

@RestController
public class TestController {
    private final ElectionRepository electionRepository;

    public TestController(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @CrossOrigin(origins = Constants.FRONT_END_URL)
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

    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @PostMapping("/testPOST")
    public String postTestJSON(@RequestBody TestRequest requestBody) {
        System.out.println(requestBody);
        return "okay";
    }

    @PostMapping("/testCreateElections")
    public void postTestElectionCreation(@RequestBody List<ElectionInformation> electionInformation) {
        electionRepository.saveAll(electionInformation);
    }

}