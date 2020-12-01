package com.message.impl;

import com.message.controller.UserController;
import com.message.dao.UserManager;

import java.util.LinkedHashMap;

public class UserGroups implements UserManager {
    public static UserGroups userManager;

    public static UserGroups getInstance(){
        if(userManager == null){
            userManager = new UserGroups();
        }

        return userManager;
    }

    public LinkedHashMap<Integer, String> getGroups(){
        UserController uc = new UserController();
        return uc.getAllUserGroups();
    }

    public static void main(String args[]){
        UserGroups um = UserGroups.getInstance();

        System.out.println(um.getGroups());
    }
}
