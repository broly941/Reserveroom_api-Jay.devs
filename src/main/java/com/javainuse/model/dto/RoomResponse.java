package com.javainuse.model.dto;

import com.javainuse.model.Room;
import lombok.Getter;
import lombok.Setter;

/**
 * Provides information about a Room.
 */
@Getter
@Setter
public class RoomResponse {
    private String name;

    public RoomResponse() {}

    public RoomResponse(Room room) {
        name = room.getName();
    }
}
