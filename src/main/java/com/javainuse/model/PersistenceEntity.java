package com.javainuse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Provides general information about an item.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class PersistenceEntity {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue
    private Long id;
}
