package com.election.reminders.persistence;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "election_entity")
@Getter
@Setter
@ToString
public class ElectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID entityId;

    @ElementCollection
    @CollectionTable(name = "election_entity_names", joinColumns = @JoinColumn(name = "election_entity_id"))
    @Column(name = "entity_name", nullable = false)
    private List<String> entityNames;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntityType entityType;

    @Column()
    private String description;
}
