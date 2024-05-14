package com.election.reminders.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElectionsForCountryRequest {
    @JsonProperty("countryName")
    private String countryName;
}
