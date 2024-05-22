package com.election.reminders.dtos.jackson.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElectionsForCountryRequest {
    @JsonProperty("countryName")
    private String countryName;
}
