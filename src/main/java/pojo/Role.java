package pojo;

import java.util.List;

/**
 * Created by jgarcias on 24/01/17.
 */
public class Role {

    private String roleName;
    private String roleDesc;
    private List<User> userList;

    public Role(String rname, String desc) {
        this.roleName = rname;
        this.roleDesc = desc;
    }
    public Role(String rname, List<User> userList) {
        this.roleName = rname;
        this.userList = userList;
    }

    public Role() {
    }

    public Role(String rname) {
        this.roleName = rname;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

