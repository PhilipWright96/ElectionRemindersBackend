package com.election.reminders.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.election.reminders.dtos.jackson.responses.ReminderInformation;
import com.election.reminders.utils.TestDataBuilder;

@Repository
public class ReminderRepository {
    public List<ReminderInformation> getRemindersForUser(String userId) {
        return TestDataBuilder.constructDummyReminderInformations();
    }
}
