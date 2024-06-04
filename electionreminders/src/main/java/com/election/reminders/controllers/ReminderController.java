package com.election.reminders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.reminders.dtos.jackson.responses.ReminderInformation;
import com.election.reminders.services.ReminderService;
import com.election.reminders.utils.IJavaToJSONConverter;

@RestController
public class ReminderController {
    private final ReminderService reminderService;
    private final IJavaToJSONConverter javaToJSONConverter;

    @Autowired
    public ReminderController(ReminderService reminderService, IJavaToJSONConverter javaToJSONConverter) {
        this.reminderService = reminderService;
        this.javaToJSONConverter = javaToJSONConverter;
    }

    @CrossOrigin(origins = Constants.FRONT_END_URL)
    @GetMapping("/remindersForUser")
    public String getRemindersForUser(@RequestParam String userId) {
        final List<ReminderInformation> remindersForUser = reminderService.getRemindersForUser(userId);
        return javaToJSONConverter.convertJavaToJSON(remindersForUser);
    }
}
