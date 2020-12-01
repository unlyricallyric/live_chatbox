package com.message.impl;

import com.message.controller.UserController;
import com.message.dao.UserManager;

import java.util.LinkedHashMap;

public class UserManagerImpl implements UserManager {
    public static UserManagerImpl userManager;
    public static LinkedHashMap<Integer, String> groups;

    private UserManagerImpl(){
        groups = getGroups();
    }

    public static UserManagerImpl getInstance(){
        if(userManager == null){
            userManager = new UserManagerImpl();
        }

        return userManager;
    }

    public LinkedHashMap<Integer, String> getGroups(){
        UserController uc = new UserController();
        return uc.getAllUserGroups();
    }

    public static void main(String args[]){
        UserManagerImpl um = UserManagerImpl.getInstance();

        System.out.println(um.getGroups());
    }
}
