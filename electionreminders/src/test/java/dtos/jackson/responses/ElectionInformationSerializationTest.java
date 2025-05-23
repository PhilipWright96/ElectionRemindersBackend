package dtos.jackson.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.election.reminders.builders.ElectionInformationBuilder;
import com.election.reminders.dtos.jackson.responses.ElectionInformationDto;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ElectionInformationSerializationTest {
    @Test
    void electionInformation_withValuesForAllFields_objectIsCorrectlySerializedToJSON() {
        // Given
        final ElectionInformationBuilder builder = new ElectionInformationBuilder()
                .electionName("Election abc")
                .electionId(UUID.fromString("f2be4dea-2e1f-403e-ad82-42f737daa0eb"))
                .electionDate(LocalDateTime.of(2024, 1, 1, 0, 0))
                .electionSummary("This is a summary of election abc.")
                .isRepeating(true)
                .countryName("A country")
                .repeatingEvery("4 years");

        final ElectionInformationDto electionInformation = new ElectionInformationDto(builder);

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // When
        String electionObjectAsJsonString = "";
        try {
            electionObjectAsJsonString = objectMapper.writeValueAsString(electionInformation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Then
        final String expectedJsonString = "{"
                + "\"electionId\":\"f2be4dea-2e1f-403e-ad82-42f737daa0eb\","
                + "\"electionName\":\"Election abc\","
                + "\"electionDate\":\"2024-01-01T00:00:00\","
                + "\"electionSummary\":\"This is a summary of election abc.\","
                + "\"isRepeating\":true,"
                + "\"repeatingEvery\":\"4 years\","
                + "\"countryName\":\"A country\""
                + "}";

        assertEquals(expectedJsonString, electionObjectAsJsonString, "Election object mapped incorrectly to string");
    }
}
