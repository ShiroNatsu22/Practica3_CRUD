package pojo;

/**
 * Created by jgarcias on 24/01/17.
 */
public class Role {

    private String roleName;
    private String roleDesc;

    public Role(String rname, String desc) {
        this.roleName = rname;
        this.roleDesc = desc;
    }

    public Role() {
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
}

