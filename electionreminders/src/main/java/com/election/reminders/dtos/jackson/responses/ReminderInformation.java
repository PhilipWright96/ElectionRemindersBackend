package com.election.reminders.dtos.jackson.responses;

import com.election.reminders.builders.ReminderInformationBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReminderInformation {
    public ReminderInformation(ReminderInformationBuilder builder) {
        this.reminderName = builder.getReminderName();
        this.electionId = builder.getElectionId();
        this.createdOn = builder.getCreatedOn();
        this.reminderDate = builder.getReminderDate();
        this.reminderDetails = builder.getReminderDetails();
    }

    @JsonProperty("reminderName")
    public String reminderName;
    @JsonProperty("electionId")
    public String electionId;
    @JsonProperty("createdOn")
    public String createdOn;
    @JsonProperty("reminderDate")
    public String reminderDate;
    @JsonProperty("reminderDetails")
    public String reminderDetails;
}
