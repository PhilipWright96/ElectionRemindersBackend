package com.election.reminders.repositories;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.election.reminders.persistence.ElectionEntity;

@Repository
public interface ElectionEntityRepository extends JpaRepository<ElectionEntity, UUID> {
    @Query("""
            SELECT DISTINCT e
            FROM ElectionEntity e
            JOIN e.entityNames n
            WHERE n IN :names
            """)
    List<ElectionEntity> findByAnyEntityName(@Param("names") Collection<String> names);
}