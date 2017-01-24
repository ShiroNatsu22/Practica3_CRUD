package pojo;

import java.util.List;

/**
 * Created by jgarcias on 24/01/17.
 */

    public class User {
        private String name;
        private List<Rol> getAllUser;

        public User(String name, String pass) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


