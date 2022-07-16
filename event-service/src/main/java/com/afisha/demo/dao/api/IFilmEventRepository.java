package com.afisha.demo.dao.api;

import com.afisha.demo.dao.entity.FilmEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFilmEventRepository extends PagingAndSortingRepository<FilmEvent, UUID> {
}
