package dao;

import pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jgarcias on 24/01/17.
 */
public interface UserDao {
    User findUser(String userName);
    List<User> findUser(String name, boolean fillRoll);
    void deleteUser(String name) throws SQLException;
    void insertUser(String name,String password,String[] roles) throws SQLException;
    List<User> getUsers() throws SQLException;
}
