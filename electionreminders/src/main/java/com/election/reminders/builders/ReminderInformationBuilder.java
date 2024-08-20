package com.election.reminders.builders;

import java.time.LocalDateTime;
import java.util.UUID;

import com.election.reminders.dtos.jackson.responses.ReminderInformation;

public class ReminderInformationBuilder {
    private UUID reminderId;
    private String reminderName;
    private UUID electionId;
    private LocalDateTime reminderDate;
    private LocalDateTime createdOn;
    private String reminderDetails;

    public ReminderInformationBuilder reminderId(UUID reminderId) {
        this.reminderId = reminderId;
        return this;
    }

    public UUID getReminderId() {
        return this.reminderId;
    }

    public ReminderInformationBuilder reminderName(String reminderName) {
        this.reminderName = reminderName;
        return this;
    }

    public String getReminderName() {
        return this.reminderName;
    }

    public ReminderInformationBuilder electionId(UUID electionId) {
        this.electionId = electionId;
        return this;
    }

    public UUID getElectionId() {
        return this.electionId;
    }

    public ReminderInformationBuilder reminderDate(LocalDateTime reminderDate) {
        this.reminderDate = reminderDate;
        return this;
    }

    public LocalDateTime getReminderDate() {
        return this.reminderDate;
    }

    public ReminderInformationBuilder createdOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public ReminderInformationBuilder reminderDetails(String reminderDetails) {
        this.reminderDetails = reminderDetails;
        return this;
    }

    public String getReminderDetails() {
        return this.reminderDetails;
    }

    public ReminderInformation build() {
        return new ReminderInformation(this);
    }
}
