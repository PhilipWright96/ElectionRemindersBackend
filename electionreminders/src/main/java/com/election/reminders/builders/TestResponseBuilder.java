package com.election.reminders.builders;

import com.election.reminders.dtos.jackson.responses.TestResponse;

public class TestResponseBuilder {
    private String electionName;
    private String electionDate;
    private String electionSummary;
    private Boolean isRepeating;
    private String repeatingEvery;

    public TestResponseBuilder electionName(String electionName) {
        this.electionName = electionName;
        return this;
    }

    public String getElectionName() {
        return this.electionName;
    }

    public TestResponseBuilder electionDate(String electionDate) {
        this.electionDate = electionDate;
        return this;
    }

    public String getElectionDate() {
        return this.electionDate;
    }

    public TestResponseBuilder electionSummary(String electionSummary) {
        this.electionSummary = electionSummary;
        return this;
    }

    public String getElectionSummary() {
        return this.electionSummary;
    }

    public TestResponseBuilder isRepeating(Boolean isRepeating) {
        this.isRepeating = isRepeating;
        return this;
    }

    public Boolean getIsRepeating() {
        return this.isRepeating;
    }

    public TestResponseBuilder repeatingEvery(String repeatingEvery) {
        this.repeatingEvery = repeatingEvery;
        return this;
    }

    public String getRepeatingEvery() {
        return this.repeatingEvery;
    }

    public TestResponse build() {
        return new TestResponse(this);
    }
}
