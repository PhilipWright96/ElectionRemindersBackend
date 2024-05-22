package com.election.reminders.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.election.reminders.builders.TestResponseBuilder;
import com.election.reminders.dtos.jackson.responses.TestResponse;

@Repository
public class ElectionRepository {
    public List<TestResponse> getElectionsForCountry(String countryName) {
        return constructDummyTestResponses();
    }

    private List<TestResponse> constructDummyTestResponses() {
        TestResponse testResponse1 = new TestResponseBuilder().electionName("A").electionDate("Date for A")
                .electionSummary("Summary for A").isRepeating(false).build();

        TestResponse testResponse2 = new TestResponseBuilder().electionName("B").electionDate("Date for B")
                .electionSummary("Summary for B").isRepeating(true).repeatingEvery("3 years").build();

        final List<TestResponse> responses = List.of(testResponse1, testResponse2);
        return responses;
    }

}
