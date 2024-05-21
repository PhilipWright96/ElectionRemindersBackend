package com.election.reminders.services;

import com.election.reminders.dtos.jackson.responses.TestResponse;
import com.election.reminders.repositories.ElectionRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ElectionService {
    public List<TestResponse> getElectionsForCountry(String countryName) {
        // Should election repository be a bean here?
        return new ElectionRepository().getElectionsForCountry(countryName);
    }
}
