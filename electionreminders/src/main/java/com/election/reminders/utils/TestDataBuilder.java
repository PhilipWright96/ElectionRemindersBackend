package com.election.reminders.utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.election.reminders.builders.ElectionInformationBuilder;
import com.election.reminders.builders.ReminderInformationBuilder;
import com.election.reminders.dtos.jackson.responses.ElectionInformation;
import com.election.reminders.dtos.jackson.responses.ReminderInformation;

public class TestDataBuilder {
        public static List<ElectionInformation> constructDummyElectionInformations() {
                ElectionInformation electionInformation1 = new ElectionInformationBuilder().electionName("A")
                                .electionDate(LocalDateTime.of(2024, 1, 1, 1, 0))
                                .electionSummary("Summary for A").isRepeating(false).build();

                ElectionInformation electionInformation2 = new ElectionInformationBuilder().electionName("B")
                                .electionDate(LocalDateTime.of(2024, 2, 1, 1, 0))
                                .electionSummary("Summary for B").isRepeating(true).repeatingEvery("3 years").build();

                ElectionInformation electionInformation3 = new ElectionInformationBuilder().electionName("C")
                                .electionDate(LocalDateTime.of(2024, 3, 1, 1, 0))
                                .electionSummary("Summary for C").isRepeating(true).repeatingEvery("3 years").build();

                return List.of(electionInformation1, electionInformation2, electionInformation3);
        }

        public static List<ReminderInformation> constructDummyReminderInformations() {
                ReminderInformation reminderInformation1 = new ReminderInformationBuilder()
                                .reminderName("Reminder For A")
                                .electionId(UUID.randomUUID())
                                .reminderDate(LocalDateTime.of(2024, 1, 1, 1, 0))
                                .createdOn(LocalDateTime.of(2024, 1, 2, 1, 0))
                                .reminderDetails("Details for reminder A").build();

                ReminderInformation reminderInformation2 = new ReminderInformationBuilder()
                                .reminderName("Reminder For B")
                                .electionId(UUID.randomUUID())
                                .reminderDate(LocalDateTime.of(2024, 2, 1, 1, 0))
                                .createdOn(LocalDateTime.of(2024, 2, 2, 1, 0))
                                .reminderDetails("Details for reminder B").build();

                ReminderInformation reminderInformation3 = new ReminderInformationBuilder()
                                .reminderName("Reminder For C")
                                .electionId(UUID.randomUUID())
                                .reminderDate(LocalDateTime.of(2024, 3, 1, 1, 0))
                                .createdOn(LocalDateTime.of(2024, 3, 2, 1, 0))
                                .reminderDetails("Details for reminder c").build();

                return List.of(reminderInformation1, reminderInformation2, reminderInformation3);
        }
}
