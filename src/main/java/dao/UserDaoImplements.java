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

    public UserDaoImplements() {

    }

    public void setConnection(ConnectionFactory dbc) {
        this.dbc = dbc;
    }

    public User findUser(String userName) throws SQLException {

        String sql = "SELECT user.user_name,user.user_pass FROM dwes.user WHERE user.user_name =?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String uname = rs.getString("user.user_name");
            User user = new User(uname);

            return user;
        }


        return null;

    }

    public User findUser(String name, boolean fillRoll) throws SQLException {
        if (fillRoll) {
            String sql = "select user.user_name,user_roles.role_name from user,roles,user_roles where user.user_name = user_roles.user_name and roles.role_name = user_roles.role_name and user.user_name=?";
            PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            String uname = "";
            while (rs.next()) {
                uname = rs.getString("user.user_name");
                roleList.add(new Role(rs.getString("user_roles.role_name")));


            }
            return new User(uname, roleList);
        } else {
            return findUser(name);
        }

    }

    public void deleteUser(String name) throws SQLException {
        String sql = "DELETE FROM dwes.user_roles WHERE user_name=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();

        sql = "DELETE FROM dwes.user WHERE user_name = ?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();
    }


    public void insertUser(String name, String password, String[] roles) throws SQLException {
        String sql = "INSERT into dwes.user VALUES(?,?)";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        ps.execute();

        sql = "INSERT INTO user_roles VALUES(?,?)";
        for (int i = 0; i < roles.length; i++) {
            ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, roles[i]);
            ps.execute();
        }

    }

    public List<User> getUsers() throws SQLException {
        String sql = "SELECT * FROM dwes.user";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String uname = rs.getString("user.user_name");
            String pass = rs.getString("user.user_pass");

            User user = new User(uname, pass);
            userList.add(user);


        }
        return userList;
    }

    public void setDbc(ConnectionFactory dbc) {
        this.dbc = dbc;
    }
}

