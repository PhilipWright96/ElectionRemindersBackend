package com.election.reminders.utils;

import java.util.List;

import com.election.reminders.builders.ElectionInformationBuilder;
import com.election.reminders.builders.ReminderInformationBuilder;
import com.election.reminders.dtos.jackson.responses.ElectionInformation;
import com.election.reminders.dtos.jackson.responses.ReminderInformation;

public class TestDataBuilder {
        public static List<ElectionInformation> constructDummyElectionInformations() {
                ElectionInformation electionInformation1 = new ElectionInformationBuilder().electionName("A")
                                .electionDate("Date for A")
                                .electionSummary("Summary for A").isRepeating(false).build();

                ElectionInformation electionInformation2 = new ElectionInformationBuilder().electionName("B")
                                .electionDate("Date for B")
                                .electionSummary("Summary for B").isRepeating(true).repeatingEvery("3 years").build();

                ElectionInformation electionInformation3 = new ElectionInformationBuilder().electionName("C")
                                .electionDate("Date for C")
                                .electionSummary("Summary for C").isRepeating(true).repeatingEvery("3 years").build();

                return List.of(electionInformation1, electionInformation2, electionInformation3);
        }

        public static List<ReminderInformation> constructDummyReminderInformations() {
                ReminderInformation reminderInformation1 = new ReminderInformationBuilder()
                                .reminderName("Reminder For A").electionId("A")
                                .reminderDate("Date for A")
                                .createdOn("Created on A")
                                .reminderDetails("Details for reminder A").build();

                ReminderInformation reminderInformation2 = new ReminderInformationBuilder()
                                .reminderName("Reminder For B").electionId("B")
                                .reminderDate("Date for B")
                                .createdOn("Created on B")
                                .reminderDetails("Details for reminder B").build();

                ReminderInformation reminderInformation3 = new ReminderInformationBuilder()
                                .reminderName("Reminder For C").electionId("C")
                                .reminderDate("Date for C")
                                .createdOn("Created on C")
                                .reminderDetails("Details for reminder c").build();

                return List.of(reminderInformation1, reminderInformation2, reminderInformation3);
        }
}
