package dao;

import pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jgarcias on 24/01/17.
 */
public interface UserDAO {
    User findUser(String userName);
    List<User> findUser(String name, boolean fillRoll);
    User deleteUser(String name);
    void insertUser(String name,String password,String[] roles);
    List<User> getUsers() ;
}
