package com.afisha.demo.dao.api;

import com.afisha.demo.dao.entity.ConcertEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IConcertEventRepository extends PagingAndSortingRepository<ConcertEvent, UUID> {
}
