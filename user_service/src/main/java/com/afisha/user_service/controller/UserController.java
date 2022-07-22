package com.afisha.user_service.controller;

import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserLogin;
import com.afisha.user_service.dto.user.UserRegistration;
import com.afisha.user_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    IUserService service;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@Valid @RequestBody UserRegistration userRegistration) {
        service.register(userRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(service.login(userLogin), HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDisplay> me() {
        return new ResponseEntity<>(service.me(), HttpStatus.OK);
    }
}
