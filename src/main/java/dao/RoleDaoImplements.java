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
    private List<Role> roleList = new ArrayList<Role>();


    RoleDaoImplements() {


    }

    public void setConnection(ConnectionFactory dbc) {
        this.dbc = dbc;
    }

    public List<Role> getRoles() throws SQLException {
        String sql = "SELECT * FROM dwes.roles";
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


    public void insertRol(String roleName, String roleDesc) throws SQLException {
        String sql = "INSERT into dwes.roles VALUES(?,?)";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, roleName);
        ps.setString(2, roleDesc);
        ps.execute();

    }

    public void deleteRol(String rol_name) {

    }

    public void setDbc(ConnectionFactory dbc) {
        this.dbc = dbc;
    }
}