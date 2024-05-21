package com.election.reminders.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJavaToJSONConverter implements IJavaToJSONConverter {
    public <T> String convertJavaToJSON(List<T> objectsToConvertToJSON) {
        final ObjectMapper objectMapper = new ObjectMapper();

        String json = null;

        try {
            json = objectMapper.writeValueAsString(objectsToConvertToJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
