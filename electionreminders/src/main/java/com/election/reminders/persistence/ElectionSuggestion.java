package com.election.reminders.persistence;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "election_suggestion")
@Getter
@Setter
@ToString
public class ElectionSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID electionSuggestionId;

    @Column(nullable = false)
    private String electionName;

    @Column
    private String electionDetails;

    @Column
    private String countryName;

    @Column
    private String regionName;

    @Column
    private String cityName;

    @Column
    private String organizationName;

    @Column(nullable = false)
    private LocalDateTime electionPollsOpenDateTime;

    @Column(nullable = false)
    private LocalDateTime electionPollsCloseDateTime;

    @Column
    private String electionSummary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ElectionType electionType;
}
