package com.javainuse.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "events")
public class Event extends PersistenceEntity {
    public static final String ATTRIBUTE_USER = "user";
    public static final String ATTRIBUTE_ROOM = "room";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ROOM_ID")
    private Room room;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISH_TIME")
    private Date finishTime;
}
