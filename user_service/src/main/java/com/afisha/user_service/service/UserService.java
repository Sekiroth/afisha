package com.afisha.user_service.service;

import com.afisha.user_service.controller.utils.JwtTokenUtil;
import com.afisha.user_service.dao.api.IUserRepository;
import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.dto.user.UserLogin;
import com.afisha.user_service.dto.user.UserRegistration;
import com.afisha.user_service.service.api.IMappingService;
import com.afisha.user_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    IMappingService mappingService;
    @Autowired
    IUserRepository repository;

    @Override
    public User create(UserCreate userCreate) {
        User user = mappingService.create(userCreate);

        repository.save(user);
        return user;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User findByMail(String mail) {
        Optional<User> optional = repository.findByMail(mail);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Not found");
        }
        return optional.get();
    }

    @Override
    public User findByUuid(UUID uuid) {
        Optional<User> optional = repository.findById(uuid);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Not found");
        }
        return optional.get();
    }

    @Override
    public User update(UUID uuid, Integer dtUpdate, UserCreate userCreate) {
        User user = findByUuid(uuid);
        User update = mappingService.update(userCreate, user, dtUpdate);
        repository.save(update);
        return update;
    }

    @Override
    public void register(UserRegistration userRegistration) {
        if (userRegistration.getMail().equals(findByMail(userRegistration.getMail()).getMail())) {
            throw new IllegalArgumentException("Already exists");
        }
        repository.save(mappingService.create(userRegistration));
    }

    @Override
    public String login(UserLogin userLogin) {
        UserDetails details = findByMail(userLogin.getMail());
        return JwtTokenUtil.generateAccessToken(details);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return findByMail(mail);
    }

    @Override
    public UserDisplay me() {
        UserDetails user = UserHolder.getUser();
        return mappingService.read(findByMail(user.getUsername()));
    }
}
