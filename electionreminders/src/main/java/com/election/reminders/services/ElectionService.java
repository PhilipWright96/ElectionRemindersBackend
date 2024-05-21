package com.election.reminders.services;

import com.election.reminders.dtos.responses.TestResponse;

import java.util.List;

public class ElectionService {
    public List<TestResponse> getElectionsForCountry(String countryName) {
        TestResponse testResponse1 = new TestResponse();
        testResponse1.electionName = "Germany";

        TestResponse testResponse2 = new TestResponse();
        testResponse2.electionName = "France";

        final List<TestResponse> responses = List.of(testResponse1, testResponse2);
        return responses;
    }
}
