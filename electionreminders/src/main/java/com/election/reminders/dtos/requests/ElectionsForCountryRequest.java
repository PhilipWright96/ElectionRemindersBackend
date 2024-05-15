package com.election.reminders.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElectionsForCountryRequest {
    @JsonProperty("countryName")
    private String countryName;
}
