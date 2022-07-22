package com.afisha.user_service.dao.api;

import com.afisha.user_service.dao.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, UUID> {
    Optional<User> findByMail(String mail);
}
