package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgarcias on 24/01/17.
 */

public class User {
    private String name;
    private String password;
    private List<Role> roles = new ArrayList<Role>();

    public User(String uname,String password) {

        this.name = uname;
        this.password = password;

    }

    public User(String uname){
        this.name = uname;
    }

    public User(String uname, List<Role> roles) {
        this.name = uname;
        this.roles = roles;
    }


    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}


