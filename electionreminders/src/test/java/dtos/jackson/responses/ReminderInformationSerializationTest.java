package dtos.jackson.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.election.reminders.builders.ReminderInformationBuilder;
import com.election.reminders.dtos.jackson.responses.ReminderInformation;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ReminderInformationSerializationTest {
    @Test
    void reminderInformation_withValuesForAllFields_objectIsCorrectlySerializedToJSON() {
        // Given
        final ReminderInformationBuilder builder = new ReminderInformationBuilder()
                .reminderId(UUID.fromString("befe4dea-2e1f-403e-ad82-42f737daa0eb"))
                .reminderName("Reminder abc")
                .electionId(UUID.fromString("cefe4dea-2e1f-403e-ad82-42f737daa0eb"))
                .createdOn(LocalDateTime.of(2024, 1, 1, 0, 0))
                .reminderDate(LocalDateTime.of(2024, 2, 1, 0, 0))
                .reminderDetails("Remind me in 4 days");

        final ReminderInformation reminderInformation = new ReminderInformation(builder);

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // When
        String reminderObjectAsJsonString = "";
        try {
            reminderObjectAsJsonString = objectMapper.writeValueAsString(reminderInformation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Then
        final String expectedJsonString = "{"
                + "\"reminderId\":\"befe4dea-2e1f-403e-ad82-42f737daa0eb\","
                + "\"reminderName\":\"Reminder abc\","
                + "\"electionId\":\"cefe4dea-2e1f-403e-ad82-42f737daa0eb\","
                + "\"createdOn\":\"2024-01-01T00:00:00\","
                + "\"reminderDate\":\"2024-02-01T00:00:00\","
                + "\"reminderDetails\":\"Remind me in 4 days\""
                + "}";

        assertEquals(expectedJsonString, reminderObjectAsJsonString, "Reminder object mapped incorrectly to string");
    }
}
