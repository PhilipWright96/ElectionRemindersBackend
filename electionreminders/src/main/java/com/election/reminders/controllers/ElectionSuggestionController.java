package com.election.reminders.controllers;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.persistence.ElectionSuggestion;
import com.election.reminders.repositories.ElectionSuggestionRepository;
import com.election.reminders.services.ElectionService;

@RestController
public class ElectionSuggestionController {
    private final ElectionSuggestionRepository electionSuggestionRepository;

    private static final Logger logger = LoggerFactory.getLogger(ElectionController.class);

    public ElectionSuggestionController(ElectionService electionService,
            ElectionSuggestionRepository electionSuggestionRepository) {
        this.electionSuggestionRepository = electionSuggestionRepository;
    }

    @CrossOrigin(origins = { "https://electionreminders.space", "https://localhost", "http://localhost",
            Constants.FRONT_END_URL })
    @PostMapping("/electionSuggestions")
    public void createElectionSuggestion(@RequestBody List<ElectionSuggestion> electionSuggestions) {
        logger.info("Saving election suggestions");
        electionSuggestions.forEach((election) -> logger.info(election.toString()));
        electionSuggestionRepository.saveAll(electionSuggestions);
    }

    @GetMapping("/admin/electionSuggestions")
    public List<ElectionSuggestion> getElectionSuggestions() {
        logger.info("Returning elections");
        return electionSuggestionRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/electionSuggestionsFromDashboard")
    public List<ElectionSuggestion> getElectionSuggestionsForDashboard() {
        logger.info("Returning elections");
        return electionSuggestionRepository.findAll();
    }

    @DeleteMapping("/admin/electionSuggestions")
    public void deleteElections(@RequestBody List<ElectionSuggestion> electionSuggestions) {
        logger.info("Deleting election suggestions");
        electionSuggestions.forEach((electionSuggestion) -> logger.info(electionSuggestion.toString()));
        electionSuggestionRepository.deleteAll(electionSuggestions);
    }

    @DeleteMapping("/admin/electionSuggestionsByIds")
    public void deleteElectionSuggestionsByIds(@RequestBody List<UUID> electionSuggestionIds) {
        logger.info("Deleting elections");
        logger.info(electionSuggestionIds.toString());
        electionSuggestionRepository.deleteAllById(electionSuggestionIds);
    }

    // Anyone calling this endpoint should do so from our dashboard.
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/electionSuggestionsByIdsFromDashboard")
    public void deleteElectionSuggestionsByIdsFromDashboard(@RequestBody List<UUID> electionSuggestionIds) {
        logger.info("Deleting elections");
        logger.info(electionSuggestionIds.toString());
        electionSuggestionRepository.deleteAllById(electionSuggestionIds);
    }

}