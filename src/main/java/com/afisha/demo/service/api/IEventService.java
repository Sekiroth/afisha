package com.afisha.demo.service.api;

import com.afisha.demo.dto.Event;
import com.afisha.demo.dao.entity.enums.Type;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IEventService {
    Event save(Event event, Type type);
    Event findOne(UUID uuid, Type type);
    List<? extends Event> findAll(Type type);
    void delete(Event event, Type type);
    Event update(Event event, Type type, Integer dtUpdate, UUID uuid);
}
