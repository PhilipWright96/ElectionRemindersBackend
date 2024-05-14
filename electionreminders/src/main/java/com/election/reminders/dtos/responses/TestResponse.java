package com.election.reminders.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResponse {
    @JsonProperty("electionName")
    public String electionName;
}
