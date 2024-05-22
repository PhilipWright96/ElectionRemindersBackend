package com.election.reminders.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.election.reminders.dtos.jackson.responses.ElectionInformation;
import com.election.reminders.utils.TestDataBuilder;

@Repository
public class ElectionRepository {
    public List<ElectionInformation> getElectionsForCountry(String countryName) {
        return TestDataBuilder.constructDummyElectionInformations();
    }
}
