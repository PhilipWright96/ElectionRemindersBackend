package com.election.reminders.dtos.jackson.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResponse {
    @JsonProperty("electionName")
    public String electionName;
}
