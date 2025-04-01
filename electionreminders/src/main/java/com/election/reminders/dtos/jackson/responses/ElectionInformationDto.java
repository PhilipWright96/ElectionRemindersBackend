package com.election.reminders.dtos.jackson.responses;

import java.time.LocalDateTime;
import java.util.UUID;

import com.election.reminders.builders.ElectionInformationBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ElectionInformationDto {
    // No arg constructor to allow for MapStruct to properly generate mapping code
    public ElectionInformationDto() {
    }

    public ElectionInformationDto(ElectionInformationBuilder builder) {
        this.electionId = builder.getElectionId();
        this.electionName = builder.getElectionName();
        this.electionDate = builder.getElectionDate();
        this.electionSummary = builder.getElectionSummary();
        this.isRepeating = builder.getIsRepeating();
        this.repeatingEvery = builder.getRepeatingEvery();
        this.countryName = builder.getCountryName();
    }

    @JsonProperty("electionId")
    public UUID electionId;
    @JsonProperty("electionName")
    public String electionName;
    @JsonProperty("electionDate")
    public LocalDateTime electionDate;
    @JsonProperty("electionSummary")
    public String electionSummary;
    @JsonProperty("isRepeating")
    public Boolean isRepeating;
    @JsonProperty("repeatingEvery")
    public String repeatingEvery;
    @JsonProperty("countryName")
    public String countryName;
}
