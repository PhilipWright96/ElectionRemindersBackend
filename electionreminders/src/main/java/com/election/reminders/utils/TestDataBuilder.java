package com.election.reminders.utils;

import java.time.LocalDateTime;
import java.util.List;

import com.election.reminders.builders.ElectionInformationBuilder;
import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;

public class TestDataBuilder {
        public static List<ElectionInformationDto> constructDummyElectionInformations() {
                ElectionInformationDto electionInformation1 = new ElectionInformationBuilder().electionName("A")
                                .electionDate(LocalDateTime.of(2025, 4, 1, 1, 0))
                                .electionSummary("Summary for A").isRepeating(false).build();

                ElectionInformationDto electionInformation2 = new ElectionInformationBuilder().electionName("B")
                                .electionDate(LocalDateTime.of(2025, 5, 1, 1, 0))
                                .electionSummary("Summary for B").isRepeating(true).repeatingEvery("3 years").build();

                ElectionInformationDto electionInformation3 = new ElectionInformationBuilder().electionName("C")
                                .electionDate(LocalDateTime.of(2026, 6, 1, 1, 0))
                                .electionSummary("Summary for C").isRepeating(true).repeatingEvery("3 years").build();

                return List.of(electionInformation1, electionInformation2, electionInformation3);
        }
}
