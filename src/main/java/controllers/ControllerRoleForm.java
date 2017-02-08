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
public class ControllerRoleForm extends HttpServlet{

    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName;
        String roleDesc;

        if (req.getParameter("roleName") != null) {
            //Se crea un rol
            roleName = req.getParameter("roleName");
            roleDesc = req.getParameter("desc");

            try {
                rdi.insertRole(roleName, roleDesc);
            } catch (SQLException e) {
                e.printStackTrace();
                java.io.PrintWriter out = resp.getWriter();
                out.println("<p>Rol duplicado, introdusca otro poh faboh</p>");
            }
        }

        resp.sendRedirect("RoleList");

    }
}

