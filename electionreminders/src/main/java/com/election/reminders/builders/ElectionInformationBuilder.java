package com.election.reminders.builders;

import java.time.LocalDateTime;
import java.util.UUID;

import com.election.reminders.dtos.jackson.responses.ElectionInformation;

public class ElectionInformationBuilder {
    private UUID electionId;
    private String electionName;
    private LocalDateTime electionDate;
    private String electionSummary;
    private Boolean isRepeating;
    private String repeatingEvery;

    public ElectionInformationBuilder electionId(UUID electionId) {
        this.electionId = electionId;
        return this;
    }

    public UUID getElectionId() {
        return this.electionId;
    }

    public ElectionInformationBuilder electionName(String electionName) {
        this.electionName = electionName;
        return this;
    }

    public String getElectionName() {
        return this.electionName;
    }

    public ElectionInformationBuilder electionDate(LocalDateTime electionDate) {
        this.electionDate = electionDate;
        return this;
    }

    public LocalDateTime getElectionDate() {
        return this.electionDate;
    }

    public ElectionInformationBuilder electionSummary(String electionSummary) {
        this.electionSummary = electionSummary;
        return this;
    }

    public String getElectionSummary() {
        return this.electionSummary;
    }

    public ElectionInformationBuilder isRepeating(Boolean isRepeating) {
        this.isRepeating = isRepeating;
        return this;
    }

    public Boolean getIsRepeating() {
        return this.isRepeating;
    }

    public ElectionInformationBuilder repeatingEvery(String repeatingEvery) {
        this.repeatingEvery = repeatingEvery;
        return this;
    }

    public String getRepeatingEvery() {
        return this.repeatingEvery;
    }

    public ElectionInformation build() {
        return new ElectionInformation(this);
    }
}
