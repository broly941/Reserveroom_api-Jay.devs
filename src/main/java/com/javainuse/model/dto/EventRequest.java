package com.javainuse.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Provides information about an Event.
 */
@Getter
@Setter
public class EventRequest {
    private Long userId;
    private Long roomId;
    private Long startTimeNumber;
    private Long finishTimeNumber;
}
