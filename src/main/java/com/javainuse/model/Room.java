package com.javainuse.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rooms")
public class Room extends PersistenceEntity {
    public static final String ATTRIBUTE_NAME = "name";

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = Event.ATTRIBUTE_ROOM)
    Set<Event> events;
}
