package com.election.reminders.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.election.reminders.controllers.TestController;
import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import com.election.reminders.persistence.ElectionInformation;

@Component
public class ElectionInformationMapper {
    @Autowired
    private ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    public ElectionInformationDto electionInformationToElectionInformationDto(ElectionInformation electionInformation) {
        return modelMapper.map(electionInformation, ElectionInformationDto.class);
    }

    public List<ElectionInformationDto> electionInformationToElectionInformationDto(
            List<ElectionInformation> electionInformations) {
        logger.info("Election info is " + electionInformations.toString());
        return electionInformations.stream()
                .map(electionInformation -> modelMapper.map(electionInformation, ElectionInformationDto.class))
                .collect(Collectors.toList());
    }
}
