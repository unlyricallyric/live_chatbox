package com.message.dao;

import com.message.model.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {

    int createUser(User user);
    boolean findUser(String username, String password);
    boolean updateUser(User user);
    String getUserGroup(String username);

}
