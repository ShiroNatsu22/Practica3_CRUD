package dao;

/**
 * Created by Joshua on 26/01/2017.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dbc.ConnectionFactory;
import pojo.Role;
import pojo.User;

public class UserDaoImplements implements UserDao {


    private ConnectionFactory dbc;
    private ArrayList<User> userList = new ArrayList<User>();
    private List<Role> roleList = new ArrayList<Role>();
    List<User> users;

    public UserDaoImplements(){


    }

    public void setConnection(ConnectionFactory dbc){
        this.dbc = dbc;
    }

    public User findUser(String userName) {
        return null;
    }

    public List<User> findUser(String name, boolean fillRoll) {
        return null;
    }

    public void deleteUser(String name) throws SQLException {
        String sql = "DELETE FROM  user_roles where user_name=?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1,name);
        ps.execute();
        sql = "DELETE FROM user where user_name=?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1,name);
        ps.execute();


    }

    public void insertUser(String name, String password, String[] roles) throws SQLException {
        String sql = "INSERT into dwes.user VALUES(?,?)";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);

        ps.execute();

    }

    public List<User> getUsers() throws SQLException {
        String sql = "SELECT * FROM dwes.user";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String uname = rs.getString("user.user_name");
            String pass = rs.getString("user.user_pass");

            User user = new User(uname,pass);
            userList.add(user);


        }
        return userList;
    }

    public void setDbc(ConnectionFactory dbc) {
        this.dbc = dbc;
    }
}

