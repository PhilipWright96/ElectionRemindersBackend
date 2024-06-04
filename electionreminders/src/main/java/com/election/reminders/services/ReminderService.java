package com.election.reminders.services;

import com.election.reminders.dtos.jackson.responses.ReminderInformation;
import com.election.reminders.repositories.ReminderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<ReminderInformation> getRemindersForUser(String userId) {
        return reminderRepository.getRemindersForUser(userId);
    }
}