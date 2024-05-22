package com.election.reminders.utils;

import java.util.List;

import com.election.reminders.builders.ElectionInformationBuilder;
import com.election.reminders.dtos.jackson.responses.ElectionInformation;

public class TestDataBuilder {
    public static List<ElectionInformation> constructDummyElectionInformations() {
        ElectionInformation ElectionInformation1 = new ElectionInformationBuilder().electionName("A")
                .electionDate("Date for A")
                .electionSummary("Summary for A").isRepeating(false).build();

        ElectionInformation ElectionInformation2 = new ElectionInformationBuilder().electionName("B")
                .electionDate("Date for B")
                .electionSummary("Summary for B").isRepeating(true).repeatingEvery("3 years").build();

        ElectionInformation ElectionInformation3 = new ElectionInformationBuilder().electionName("C")
                .electionDate("Date for C")
                .electionSummary("Summary for C").isRepeating(true).repeatingEvery("3 years").build();

        return List.of(ElectionInformation1, ElectionInformation2, ElectionInformation3);
    }
}
