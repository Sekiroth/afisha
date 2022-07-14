package com.afisha.demo.dao.entity;

import com.afisha.demo.dto.Event;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="event_concert", schema="demo")
public class ConcertEvent extends Event {

//    @OneToOne(targetEntity = Concert.class, cascade = CascadeType.ALL)
//    @JoinTable(name = "events_actions",
//            joinColumns = @JoinColumn(name = "event_uuid", referencedColumnName = "uuid"),
//            inverseJoinColumns = @JoinColumn(name = "action_uuid", referencedColumnName = "uuid")
//    )
    private UUID category;

    public ConcertEvent(Event event, UUID category) {
        super(event.getTitle(), event.getDescription(), event.getDtEvent(), event.getDtEndOfSale(), event.getType(), event.getStatus());
        this.category = category;
    }

    public ConcertEvent() {}

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }
}
