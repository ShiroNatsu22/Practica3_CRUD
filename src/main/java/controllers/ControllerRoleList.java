package controllers;

import dao.RoleDaoImplements;
import dao.UserDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 05/02/2017.
 */
public class ControllerRoleList extends HttpServlet{

    private List<Role> roleList = new ArrayList<Role>();
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            roleList = rdi.getRoles();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        req.setAttribute("rList", roleList);

        req.getRequestDispatcher("RoleList.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName;
        String newRole;
        List<User> userList;

        if (req.getParameter("deleteRole") != null) {
            //Para borrar un rol

            roleName = req.getParameter("deleteRole");

            try {
                rdi.deleteRole(roleName);
                resp.sendRedirect("RoleList");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if(req.getParameter("newRole") != null){
            roleName = req.getParameter("oldRole");
            newRole = req.getParameter("newRole");

            try {
                userList = rdi.findRole(roleName).getUserList();
                rdi.updateRole(roleName, newRole, userList);
                resp.sendRedirect("RoleList");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }
}
