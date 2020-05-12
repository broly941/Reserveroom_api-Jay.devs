package com.javainuse.repository;

import com.javainuse.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    Collection<Event> findAllByUserId(Long userId);
}