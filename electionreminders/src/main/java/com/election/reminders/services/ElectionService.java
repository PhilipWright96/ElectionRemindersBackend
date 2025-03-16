package com.election.reminders.services;

import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import com.election.reminders.mappers.ElectionInformationMapper;
import com.election.reminders.repositories.ElectionRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ElectionService {
    private final ElectionRepository electionRepository;
    private final ElectionInformationMapper electionInformationMapper;

    public ElectionService(ElectionRepository electionRepository, ElectionInformationMapper electionInformationMapper) {
        this.electionRepository = electionRepository;
        this.electionInformationMapper = electionInformationMapper;
    }

    public List<ElectionInformationDto> getElectionsForCountry(String countryName) {
        return electionInformationMapper
                .electionInformationToElectionInformationDto(electionRepository.findByCountryName(countryName));
    }
}
