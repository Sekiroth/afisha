package com.afisha.demo;

import com.afisha.demo.dao.entity.enums.Type;
import com.afisha.demo.dto.BaseEssence;
import com.afisha.demo.dto.CreationEvent;
import com.afisha.demo.dto.Event;
import com.afisha.demo.service.EventService;
import com.afisha.demo.service.api.IEventService;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main1 {
    public static void main(String[] args) {
        IEventService iEventService = new EventService();
        CreationEvent creationEvent = new CreationEvent();
//        System.out.println(iEventService.findAll(Type.FILMS));
//        creationEvent.setTitle("Freier Fall");
        creationEvent.setCountry(UUID.randomUUID());
        creationEvent.setTitle("af");
        Event concertEvent = CreationEvent.getSpecificEvent(creationEvent, Type.FILMS);
        System.out.println(concertEvent.getTitle());
//        iEventService.update(concertEvent, Type.FILMS, 1657681820, UUID.fromString("a01404be-a0e0-4c53-b6ca-3408fba0cbe3"));
        BaseEssence baseEssence = BaseEssence.getInstance();
        System.out.println(baseEssence.getUuid());
    }
}
