package com.election.reminders.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.election.reminders.persistence.ElectionSuggestion;

@Repository
public interface ElectionSuggestionRepository extends JpaRepository<ElectionSuggestion, UUID> {
}