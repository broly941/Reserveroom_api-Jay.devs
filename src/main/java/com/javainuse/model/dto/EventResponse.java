package com.javainuse.model.dto;

import com.javainuse.model.Event;
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

    public EventResponse() {
    }

    public EventResponse(Event event) {
        user = new UserResponse(event.getUser());
        room = new RoomResponse(event.getRoom());
        startDate = event.getStartTime();
        finishDate = event.getFinishTime();
    }
}
