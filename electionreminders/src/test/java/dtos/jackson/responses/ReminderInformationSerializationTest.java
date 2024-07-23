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
                .reminderName("Reminder abc")
                .electionId(UUID.randomUUID())
                .createdOn(LocalDateTime.of(2024, 1, 1, 0, 0))
                .reminderDate(LocalDateTime.of(2024, 2, 1, 0, 0))
                .reminderDetails("reminder me blah blah blah");

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
                + "\"reminderName\":\"Reminder abc\","
                + "\"electionId\":\"election abc\","
                + "\"createdOn\":\"2024-01-01T00:00:00\","
                + "\"reminderDate\"2024-02-01T00:00:00,"
                + "\"reminderDetails\":\"4 years\""
                + "}";

        assertEquals(expectedJsonString, reminderObjectAsJsonString, "Reminder object mapped incorrectly to string");
    }
}
