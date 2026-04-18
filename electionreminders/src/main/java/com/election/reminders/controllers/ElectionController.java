package com.election.reminders.controllers;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import com.election.reminders.persistence.ElectionInformation;
import com.election.reminders.repositories.ElectionRepository;
import com.election.reminders.services.ElectionService;
import com.election.reminders.utils.IJavaToJSONConverter;

@RestController
public class ElectionController {
    private final ElectionService electionService;
    private final IJavaToJSONConverter javaToJSONConverter;
    private final ElectionRepository electionRepository;

    private static final Logger logger = LoggerFactory.getLogger(ElectionController.class);

    public ElectionController(ElectionService electionService, IJavaToJSONConverter javaToJSONConverter,
            ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
        this.electionService = electionService;
        this.javaToJSONConverter = javaToJSONConverter;
    }

    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/electionsForCountry")
    public String getElectionsForCountry(@RequestParam String countryName) {
        logger.info("Returning elections for " + countryName);
        final List<ElectionInformationDto> electionsForCountry = electionService.getElectionsForCountry(countryName);
        return javaToJSONConverter.convertJavaToJSON(electionsForCountry);
    }

    @GetMapping("/elections")
    public List<ElectionInformation> getElections() {
        logger.info("Returning elections");
        return electionRepository.findAll();
    }

    @PostMapping("/admin/elections")
    public void createElections(@RequestBody List<ElectionInformation> electionInformation) {
        logger.info("Saving elections");
        electionInformation.forEach((election) -> logger.info(election.toString()));
        electionRepository.saveAll(electionInformation);
    }

    // Anyone calling this endpoint should do so from our dashboard.
    @PostMapping("/electionsFromDashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public void createElectionsFromDashboard(@RequestBody List<ElectionInformation> electionInformation) {
        logger.info("Saving elections");
        electionInformation.forEach((election) -> logger.info(election.toString()));
        electionRepository.saveAll(electionInformation);
    }

    @PutMapping("/admin/elections/{id}")
    public void updateElection(@PathVariable UUID id,
            @RequestBody ElectionInformation electionInformationWithUpdatedInfo) {
        logger.info("Updating election with updated info....");
        logger.info(electionInformationWithUpdatedInfo.toString());
        ElectionInformation electionInformationToUpdate = electionRepository.findById(id).orElseThrow();
        electionInformationToUpdate.setCountryName(electionInformationWithUpdatedInfo.getCountryName());
        electionInformationToUpdate.setElectionDetails(electionInformationWithUpdatedInfo.getElectionDetails());
        electionInformationToUpdate.setElectionName(electionInformationWithUpdatedInfo.getElectionName());
        electionInformationToUpdate
                .setElectionPollsOpenDateTime(electionInformationWithUpdatedInfo.getElectionPollsOpenDateTime());
        electionInformationToUpdate
                .setElectionPollsCloseDateTime(electionInformationWithUpdatedInfo.getElectionPollsCloseDateTime());
        electionInformationToUpdate.setElectionSummary(electionInformationWithUpdatedInfo.getElectionSummary());
        electionRepository.save(electionInformationToUpdate);
    }

    @DeleteMapping("/admin/elections")
    public void deleteElections(@RequestBody List<ElectionInformation> electionInformation) {
        logger.info("Deleting elections");
        electionInformation.forEach((election) -> logger.info(election.toString()));
        electionRepository.deleteAll(electionInformation);
    }

    @DeleteMapping("/admin/electionsByIds")
    public void deleteElectionsByIds(@RequestBody List<UUID> electionIds) {
        logger.info("Deleting elections");
        logger.info(electionIds.toString());
        electionRepository.deleteAllById(electionIds);
    }
}
