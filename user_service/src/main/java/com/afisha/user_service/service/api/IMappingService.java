package com.afisha.user_service.service.api;

import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.dto.user.UserRegistration;

public interface IMappingService {
    UserDisplay read(User user);
    User create(UserCreate userCreate);
    User create(UserRegistration userRegistration);
    User update(UserCreate userCreate, User user, Integer dtUpdate);
}
