package com.message.Dao;

import com.jcraft.jsch.JSchException;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {
    String findUser(int id) throws SQLException, JSchException, IOException, ClassNotFoundException;
}
