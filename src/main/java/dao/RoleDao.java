package dao;

/**
 * Created by Joshua on 25/01/2017.
 */
import pojo.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao {

    List<Role> getRoles() throws SQLException;
    void insertRol(String rol_name,String rol_desc) throws SQLException;
    void deleteRol(String rol_name);
}
