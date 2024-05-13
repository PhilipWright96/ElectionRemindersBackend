package com.election.reminders.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRequest {
    @JsonProperty("testProperty")
    private String testProperty;
}
