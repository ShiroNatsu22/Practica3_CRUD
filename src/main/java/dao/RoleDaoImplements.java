package dao;

/**
 * Created by Joshua on 04/02/2017.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dbc.ConnectionFactory;
import pojo.Role;
import pojo.User;


public class RoleDaoImplements implements RoleDao {
    private ConnectionFactory dbc;


    RoleDaoImplements() {


    }

    public Role findRole(String roleName) throws SQLException {

        String sql = "select roles.role_name,user_roles.user_name from user,roles,user_roles where user.user_name = user_roles.user_name and roles.role_name = user_roles.role_name and roles.role_name=?";
        List<User> userList = new ArrayList<User>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, roleName);
        ResultSet rs = ps.executeQuery();

        String rname = "";
        while (rs.next()) {
            rname = rs.getString("roles.role_name");
            userList.add(new User(rs.getString("user_roles.user_name")));


        }
        return new Role(rname, userList);



    }

    public List<Role> getRoles() throws SQLException {
        String sql = "SELECT * FROM dwes.roles";
        List<Role> roleList = new ArrayList<Role>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String rname = rs.getString("roles.role_name");
            String desc = rs.getString("roles.role_description");

            Role rol = new Role(rname, desc);
            roleList.add(rol);


        }
        return roleList;
    }


    public void insertRole(String roleName, String roleDesc) throws SQLException {
        String sql = "INSERT into dwes.roles VALUES(?,?)";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, roleName);
        ps.setString(2, roleDesc);
        ps.execute();

    }

    public void deleteRole(String roleName) throws SQLException {
        String sql = "DELETE FROM dwes.user_roles WHERE role_name=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, roleName);
        ps.execute();

        sql = "DELETE FROM dwes.roles WHERE role_name = ?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, roleName);
        ps.execute();
    }

    public void updateRole(String oldRole, String newRole, List<User> userList) throws SQLException {
        String sql =  "DELETE FROM dwes.user_roles WHERE role_name=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, oldRole);
        ps.execute();

        sql = "UPDATE dwes.roles SET role_name=? where roles.role_name =?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, newRole);
        ps.setString(2, oldRole);
        ps.execute();

        sql = "INSERT into dwes.user_roles VALUES(?,?)";
        for(User user : userList) {
            ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
            ps.setString(1, newRole);
            ps.setString(2, user.getName());
            ps.execute();
        }
    }

    public void setDbc(ConnectionFactory dbc) {
        this.dbc = dbc;
    }
}
