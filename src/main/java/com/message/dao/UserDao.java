package com.message.dao;

import com.message.model.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {

    int createUser(User user);
    String findUser(int id) throws SQLException, IOException;

}
