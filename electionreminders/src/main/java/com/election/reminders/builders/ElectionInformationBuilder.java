package com.election.reminders.builders;

import com.election.reminders.dtos.jackson.responses.ElectionInformation;

public class ElectionInformationBuilder {
    private String electionName;
    private String electionDate;
    private String electionSummary;
    private Boolean isRepeating;
    private String repeatingEvery;

    public ElectionInformationBuilder electionName(String electionName) {
        this.electionName = electionName;
        return this;
    }

    public String getElectionName() {
        return this.electionName;
    }

    public ElectionInformationBuilder electionDate(String electionDate) {
        this.electionDate = electionDate;
        return this;
    }

    public String getElectionDate() {
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
