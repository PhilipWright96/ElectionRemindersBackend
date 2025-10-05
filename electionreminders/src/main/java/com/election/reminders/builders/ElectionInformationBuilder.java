package com.election.reminders.builders;

import java.time.LocalDateTime;
import java.util.UUID;

import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;

public class ElectionInformationBuilder {
    private UUID electionId;
    private String electionName;
    private String electionDetails;
    private LocalDateTime electionPollsOpenDateTime;
    private LocalDateTime electionPollsCloseDateTime;
    private String electionSummary;
    private Boolean isRepeating;
    private String repeatingEvery;
    private String countryName;

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

    public ElectionInformationBuilder electionPollsOpenDateTime(LocalDateTime electionPollsOpenDateTime) {
        this.electionPollsOpenDateTime = electionPollsOpenDateTime;
        return this;
    }

    public LocalDateTime getElectionPollsOpenDateTime() {
        return this.electionPollsOpenDateTime;
    }

    public ElectionInformationBuilder electionPollsCloseDateTime(LocalDateTime electionPollsCloseDateTime) {
        this.electionPollsCloseDateTime = electionPollsCloseDateTime;
        return this;
    }

    public LocalDateTime getElectionPollsCloseDateTime() {
        return this.electionPollsCloseDateTime;
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

    public ElectionInformationBuilder countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public ElectionInformationBuilder electionDetails(String electionDetails) {
        this.electionDetails = electionDetails;
        return this;
    }

    public String getElectionDetails() {
        return this.electionDetails;
    }

    public ElectionInformationDto build() {
        return new ElectionInformationDto(this);
    }
}
