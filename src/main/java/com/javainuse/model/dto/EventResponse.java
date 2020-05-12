package com.javainuse.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Provides information about an Event.
 */
@Getter
@Setter
public class EventResponse {
    private UserResponse user;
    private RoomResponse room;
    private Date startDate;
    private Date finishDate;
}
