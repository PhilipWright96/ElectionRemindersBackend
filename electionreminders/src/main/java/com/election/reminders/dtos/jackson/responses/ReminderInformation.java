package com.election.reminders.dtos.jackson.responses;

import java.time.LocalDateTime;
import java.util.UUID;

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
    public UUID electionId;
    @JsonProperty("createdOn")
    public LocalDateTime createdOn;
    @JsonProperty("reminderDate")
    public LocalDateTime reminderDate;
    @JsonProperty("reminderDetails")
    public String reminderDetails;
}
