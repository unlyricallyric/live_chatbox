package com.message.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {
    String findUser(int id) throws SQLException, IOException;
}
