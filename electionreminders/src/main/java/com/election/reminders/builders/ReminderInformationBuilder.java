package com.election.reminders.builders;

import com.election.reminders.dtos.jackson.responses.ReminderInformation;

public class ReminderInformationBuilder {
    private String reminderName;
    private String electionId;
    private String reminderDate;
    private String createdOn;
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

    public ReminderInformationBuilder reminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
        return this;
    }

    public String getReminderDate() {
        return this.reminderDate;
    }

    public ReminderInformationBuilder createdOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedOn() {
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
