package com.afisha.demo.service;

import com.afisha.demo.dao.api.IConcertEventRepository;
import com.afisha.demo.dao.api.IFilmEventRepository;
import com.afisha.demo.dao.entity.ConcertEvent;
import com.afisha.demo.dto.Event;
import com.afisha.demo.dao.entity.FilmEvent;
import com.afisha.demo.dao.entity.enums.Type;
import com.afisha.demo.service.api.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService implements IEventService {

    @Autowired
    IFilmEventRepository filmEventRepository;
    @Autowired
    IConcertEventRepository concertEventRepository;


    @Override
    public Event save(Event event, Type type) {
        return switch (type) {
            case FILMS -> filmEventRepository.save((FilmEvent) event);
            case CONCERTS -> concertEventRepository.save((ConcertEvent) event);
            default -> throw new IllegalArgumentException("I couldn't save the event: No type " + type + " found");
        };
    }

    @Override
    public  Event findOne(UUID uuid, Type type) {
        switch (type) {
            case FILMS -> {
                Optional<FilmEvent> filmEvent = filmEventRepository.findById(uuid);
                if (filmEvent.isEmpty()) {
                    throw new IllegalArgumentException("No film with UUID " + uuid + " found");
                } else return filmEvent.get();
            }
            case CONCERTS -> {
                Optional<ConcertEvent> concertEvent = concertEventRepository.findById(uuid);
                if (concertEvent.isEmpty()) {
                    throw new IllegalArgumentException("No concert with UUID " + uuid + " found");
                } else return concertEvent.get();
            }
            default -> throw new IllegalArgumentException("I couldn't extract the event: No type " + type + " found");
        }
    }

    @Override
    public List<? extends Event> findAll(Type type) {
        return switch (type) {
            case FILMS -> filmEventRepository.findAll();
            case CONCERTS -> concertEventRepository.findAll();
            default -> throw new IllegalArgumentException("I couldn't find the list of event: no type " + type + " found");
        };
    }

    @Override
    public void delete(Event event, Type type) {
//        return switch (type) {
//            case FILMS -> filmEventRepository.delete(Event);
//            case CONCERTS -> concertEventRepository.delete(Event);
//        };
    }

    @Override
    public Event update(Event event, Type type, Integer dtUpdate, UUID uuid) {
        Event one = findOne(uuid, type);
        one.setDtUpdate(dtUpdate);
        one.setDescription(event.getDescription());
        one.setDtEvent(event.getDtEvent());
        one.setDtEndOfSale(event.getDtEndOfSale());
        one.setTitle(event.getTitle());
        return save(one, type);
    }
}
