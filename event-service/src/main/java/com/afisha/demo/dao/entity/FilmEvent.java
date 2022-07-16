package com.afisha.demo.dao.entity;

import com.afisha.demo.dao.entity.enums.Status;
import com.afisha.demo.dao.entity.enums.Type;
import com.afisha.demo.dto.BaseEssence;
import com.afisha.demo.dto.Event;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="event_film", schema="event_service")
public class FilmEvent extends Event {

//    @OneToOne
    private UUID country;
    private Integer releaseYear;

    private LocalDate releaseDate;
    private Integer duration;

    public FilmEvent() {
    }

    public FilmEvent(Event event, UUID country, Integer releaseYear,
                     LocalDate releaseDate, Integer duration) {
        super(event.getTitle(), event.getDescription(), event.getDtEvent(), event.getDtEndOfSale(), event.getType(), event.getStatus());
        this.country = country;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public FilmEvent(UUID country, Integer releaseYear, LocalDate releaseDate, Integer duration) {
        this.country = country;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public UUID getCountry() {
        return country;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "FilmEvent{" +
                "country=" + country +
                ", releaseYear=" + releaseYear +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                '}';
    }


}
