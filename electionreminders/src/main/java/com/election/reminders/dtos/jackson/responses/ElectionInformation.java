package com.election.reminders.dtos.jackson.responses;

import java.time.LocalDateTime;

import com.election.reminders.builders.ElectionInformationBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ElectionInformation {
    public ElectionInformation(ElectionInformationBuilder builder) {
        this.electionName = builder.getElectionName();
        this.electionDate = builder.getElectionDate();
        this.electionSummary = builder.getElectionSummary();
        this.isRepeating = builder.getIsRepeating();
        this.repeatingEvery = builder.getRepeatingEvery();
    }

    @JsonProperty("electionName")
    public String electionName;
    @JsonProperty("electionDate")
    public LocalDateTime electionDate;
    @JsonProperty("electionSummary")
    public String electionSummary;
    @JsonProperty("isRepeating")
    public Boolean isRepeating;
    @JsonProperty("repeatingEvery")
    public String repeatingEvery;
}
