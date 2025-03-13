package com.election.reminders.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import com.election.reminders.persistence.ElectionInformation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ElectionInformationMapper {
    ElectionInformationDto electionInformationToElectionInformationDto(ElectionInformation electionInformation);

    List<ElectionInformationDto> electionInformationToElectionInformationDto(
            List<ElectionInformation> electionInformation);
}
