package com.message.impl;

import com.message.controller.UserController;
import com.message.dao.UserManager;

import java.util.LinkedHashMap;

public class Group1 implements UserManager {

    @Override
    public LinkedHashMap<Integer, String> getGroups() {
        UserController uc = new UserController();
        return uc.getGroup1();
    }
}
