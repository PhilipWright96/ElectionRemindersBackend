package com.election.reminders.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.persistence.ElectionEntity;
import com.election.reminders.repositories.ElectionEntityRepository;

@RestController
public class ElectionEntityController {
    private final ElectionEntityRepository electionEntityRepository;

    private static final Logger logger = LoggerFactory.getLogger(ElectionController.class);

    public ElectionEntityController(ElectionEntityRepository electionEntityRepository) {
        this.electionEntityRepository = electionEntityRepository;
    }

    @GetMapping("/electionEntities")
    public List<ElectionEntity> getElectionEntities() {
        logger.info("Returning election entities");
        return electionEntityRepository.findAll();
    }
}
