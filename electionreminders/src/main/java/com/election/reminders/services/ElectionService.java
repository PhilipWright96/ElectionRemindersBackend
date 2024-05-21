package com.election.reminders.services;

import com.election.reminders.dtos.jackson.responses.TestResponse;
import com.election.reminders.repositories.ElectionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionService {
    private final ElectionRepository electionRepository;

    @Autowired
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<TestResponse> getElectionsForCountry(String countryName) {
        return electionRepository.getElectionsForCountry(countryName);
    }
}
