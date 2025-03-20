package com.election.reminders.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import com.election.reminders.persistence.ElectionInformation;

@Component
public class ElectionInformationMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ElectionInformationDto electionInformationToElectionInformationDto(ElectionInformation electionInformation) {
        return modelMapper.map(electionInformation, ElectionInformationDto.class);
    }

    public List<ElectionInformationDto> electionInformationToElectionInformationDto(
            List<ElectionInformation> electionInformations) {
        return electionInformations.stream()
                .map(electionInformation -> modelMapper.map(electionInformation, ElectionInformationDto.class))
                .collect(Collectors.toList());
    }
}
