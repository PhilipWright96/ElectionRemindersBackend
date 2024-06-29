package com.election.reminders.builders;

import java.time.LocalDateTime;

import com.election.reminders.dtos.jackson.responses.ReminderInformation;

public class ReminderInformationBuilder {
    private String reminderName;
    private String electionId;
    private LocalDateTime reminderDate;
    private LocalDateTime createdOn;
    private String reminderDetails;

    public ReminderInformationBuilder reminderName(String reminderName) {
        this.reminderName = reminderName;
        return this;
    }

    public String getReminderName() {
        return this.reminderName;
    }

    public ReminderInformationBuilder electionId(String electionId) {
        this.electionId = electionId;
        return this;
    }

    public String getElectionId() {
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
