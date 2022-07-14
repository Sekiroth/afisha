package com.afisha.demo.dao.api;

import com.afisha.demo.dao.entity.ConcertEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IConcertEventRepository extends JpaRepository<ConcertEvent, UUID> {
}
