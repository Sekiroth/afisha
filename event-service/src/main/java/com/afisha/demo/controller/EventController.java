package com.afisha.demo.controller;

import com.afisha.demo.config.response.ResponseHandler;
import com.afisha.demo.dto.BaseEssence;
import com.afisha.demo.dto.CreationEvent;
import com.afisha.demo.dto.Event;
import com.afisha.demo.dao.entity.enums.Type;
import com.afisha.demo.service.api.IEventService;
import com.afisha.demo.service.pagination.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event")
public class EventController {

    @Autowired
    IEventService service;

    @PostMapping("/{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public Event save(@RequestBody CreationEvent event, @PathVariable Type type) {
        return service.save(new Event(BaseEssence.getInstance()), type);
    }

    @GetMapping("/{type}")
    public ResponseEntity<Object> getALl(@PathVariable Type type,
                                         @RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "25") Integer size) {
        Page<? extends Event> all = service.findAll(type, PageRequest.of(page, size));
        ResponsePage responsePage = new ResponsePage(page, size, all.getTotalPages(), (int) all.getTotalElements(), all.isFirst(), all.getNumberOfElements(), all.isLast(), all.stream().toList());
        return ResponseHandler.generateResponse(responsePage);
    }

    @GetMapping("/{type}/{uuid}?trace=true")
    public Event findOne(@PathVariable Type type, @PathVariable UUID uuid) {
        return service.findOne(uuid, type);
    }

    @PutMapping("/{type}/{uuid}/dt_update/{dt_update}")
    public Event update(@PathVariable Type type, @PathVariable UUID uuid, @PathVariable(name = "dt_update") Integer dtUpdate,
                        @RequestBody CreationEvent event) {
        Event specificEvent = CreationEvent.getSpecificEvent(event, type);
        return service.update(specificEvent, type, dtUpdate, uuid);
    }
}
