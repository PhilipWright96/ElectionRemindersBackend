package com.election.reminders.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.election.reminders.persistence.ElectionInformation;

@Repository
public interface ElectionRepository extends JpaRepository<ElectionInformation, UUID> {
    List<ElectionInformation> findByCountryName(String countryName);
}