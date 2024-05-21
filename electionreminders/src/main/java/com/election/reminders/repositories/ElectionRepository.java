package com.election.reminders.repositories;

import java.util.List;

import com.election.reminders.dtos.jackson.responses.TestResponse;

public class ElectionRepository {
    public List<TestResponse> getElectionsForCountry(String countryName) {
        TestResponse testResponse1 = new TestResponse();
        testResponse1.electionName = "Germany";

        TestResponse testResponse2 = new TestResponse();
        testResponse2.electionName = "France";

        final List<TestResponse> responses = List.of(testResponse1, testResponse2);
        return responses;
    }

}
