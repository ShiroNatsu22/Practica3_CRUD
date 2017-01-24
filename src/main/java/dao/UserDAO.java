package dao;

import pojo.User;

/**
 * Created by jgarcias on 24/01/17.
 */
public interface UserDAO {
    User findUser(String name);
    User findUser(String name, boolean fillRoll);
}
