package com.afisha.user_service.controller;

import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class AdminController {

    @Autowired
    IUserService service;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserCreate userCreate) {
        return new ResponseEntity<>(service.create(userCreate), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "20") Integer size) {
        return new ResponseEntity<>(service.findAll(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<?> findOne(@PathVariable UUID uuid) {
        return new ResponseEntity<>(service.findByUuid(uuid), HttpStatus.OK);
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<?> update(@Valid @RequestBody UserCreate userCreate,
                                    @RequestParam UUID uuid, @RequestParam(name = "dt_update") Integer dtUpdate) {
        return new ResponseEntity<>(service.update(uuid, dtUpdate, userCreate), HttpStatus.OK);
    }
}
