package dao;

/**
 * Created by Joshua on 25/01/2017.
 */
import pojo.Rol;

import java.util.List;

public interface RolDAO {

    List<Rol> getRoles();
    void insertRol(String rol_name,String rol_desc) ;
    void deleteRol(String rol_name);
}
