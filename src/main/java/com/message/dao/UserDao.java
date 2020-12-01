package com.message.dao;

import com.message.model.User;

import java.util.LinkedHashMap;

public interface UserDao {

    int createUser(User user);
    boolean findUser(String username, String password);
    boolean updateUser(User user);
    String getUserGroup(String username);
    LinkedHashMap getAllUserGroups();
    LinkedHashMap getGroup1();
    LinkedHashMap getGroup2();
    LinkedHashMap getGroup3();
}
