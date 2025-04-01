package com.election.reminders.persistence;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "election_information")
@Getter
@Setter
@ToString
public class ElectionInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID electionId;

    @Column(nullable = false)
    private String electionName;

    @Column(nullable = false)
    private String countryName;

    @Column(nullable = false)
    private LocalDateTime electionDate;

    private String electionSummary;

    private Boolean isRepeating;

    private String repeatingEvery;

}
