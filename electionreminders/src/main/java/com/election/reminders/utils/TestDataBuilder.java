package com.election.reminders.utils;

import java.util.List;

import com.election.reminders.builders.TestResponseBuilder;
import com.election.reminders.dtos.jackson.responses.TestResponse;

public class TestDataBuilder {
    public static List<TestResponse> constructDummyTestResponses() {
        TestResponse testResponse1 = new TestResponseBuilder().electionName("A").electionDate("Date for A")
                .electionSummary("Summary for A").isRepeating(false).build();

        TestResponse testResponse2 = new TestResponseBuilder().electionName("B").electionDate("Date for B")
                .electionSummary("Summary for B").isRepeating(true).repeatingEvery("3 years").build();

        TestResponse testResponse3 = new TestResponseBuilder().electionName("C").electionDate("Date for C")
                .electionSummary("Summary for C").isRepeating(true).repeatingEvery("3 years").build();

        return List.of(testResponse1, testResponse2, testResponse3);
    }
}
