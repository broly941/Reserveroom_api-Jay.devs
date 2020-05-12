package com.javainuse.service;

import com.javainuse.model.Room;
import com.javainuse.model.dto.RoomRequest;
import com.javainuse.model.dto.RoomResponse;
import com.javainuse.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public RoomResponse create(RoomRequest dto) {
        Room room = new Room();
        room.setName(dto.getName());
        return convertEntity2Dto(roomRepository.save(room));
    }

    public List<RoomResponse> getAllRooms() {
        return ((Collection<Room>) roomRepository.findAll()).stream()
                .map(this::convertEntity2Dto)
                .collect(Collectors.toList());
    }

    private RoomResponse convertEntity2Dto(Room room) {
        RoomResponse dto = new RoomResponse();
        dto.setName(room.getName());
        return dto;
    }
}
