package dao;

/**
 * Created by jgarcias on 26/01/17.
 */

import dbc.ConnectionFactory;
import pojo.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImplements implements UserDAO {
    private Connection connection;
    private Statement statement;

    public UserDaoImplements() {

    }


    public User findUser(String userName) {
        return null;
    }

    public List<User> findUser(String name, boolean fillRoll) {
        return null;
    }

    public User deleteUser(String name) {
        return null;
    }

    public void insertUser(String name, String password, String[] roles) throws SQLException {
        String query = "INSERT INTO users VALUES(?,?)";
        ResultSet rs = null;
        User user = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }


    }

    public List<User> getUsers() {
        return null;
    }
}
