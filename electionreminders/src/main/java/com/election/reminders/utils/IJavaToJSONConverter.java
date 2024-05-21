package com.election.reminders.utils;

import java.util.List;

public interface IJavaToJSONConverter {
    public <T> String convertJavaToJSON(List<T> objectsToConvertToJSON);
}
