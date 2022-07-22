package com.afisha.user_service;

import com.afisha.user_service.dao.entity.User;

public class Main1 {
    public static void main(String[] args) {
        User build = User.Builder.getInstance().build();
        System.out.println(build.getUuid());
    }
}