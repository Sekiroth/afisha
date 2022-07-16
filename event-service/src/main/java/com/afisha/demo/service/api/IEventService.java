package com.afisha.demo.service.api;

import com.afisha.demo.dto.Event;
import com.afisha.demo.dao.entity.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IEventService {
    Event save(Event event, Type type);
    Event findOne(UUID uuid, Type type);
    Page<? extends Event> findAll(Type type, Pageable pageable);
    void delete(Event event, Type type);
    Event update(Event event, Type type, Integer dtUpdate, UUID uuid);
}
