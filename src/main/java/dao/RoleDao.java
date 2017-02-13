package dao;

/**
 * Created by Joshua on 25/01/2017.
 */
import pojo.Role;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao {

    List<Role> getRoles() throws SQLException;
    void insertRole(String roleName, String roleDesc) throws SQLException;
    void deleteRole(String roleName) throws SQLException;
    void updateRole(String oldRole, String newRole, List<User> userList) throws SQLException;
    Role findRole(String role) throws SQLException;
}
