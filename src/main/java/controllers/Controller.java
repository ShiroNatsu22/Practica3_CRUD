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
 * Created by Joshua on 04/02/2017.
 */
public class Controller extends HttpServlet {


    private List<User> userList = new ArrayList<User>();
    private List<Role> roleList = new ArrayList<Role>();
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    UserDaoImplements udi = (UserDaoImplements) beans.getBean("userDaoImp");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("findUser") != null) {
            try {
                if (udi.findUser(req.getParameter("findUser")) != null) {
                    if (req.getParameter("fillRole") != null) {
                        if (req.getParameter("fillRole").equals("fillRole")) {
                            req.setAttribute("findUser", udi.findUser(req.getParameter("findUser"), true));
                        }
                    } else {
                        req.setAttribute("findUser", udi.findUser(req.getParameter("findUser"), false));
                    }

                } else {
                    req.setAttribute("error", "Puton nuub no essiste el usuaario...");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        try {
            userList = udi.getUsers();
            roleList = rdi.getRoles();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("uList", userList);
        req.setAttribute("rList", roleList);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName;
        String userPass;
        String[] roles;
        String roleName;
        String roleDesc;

        if (req.getParameter("name") != null) {
            //Se crea un nuevo usuario

            userName = req.getParameter("name");
            userPass = req.getParameter("pass");
            roles = req.getParameterValues("role");

            try {
                udi.insertUser(userName, userPass, roles);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("deleteRole") != null) {
            //Para borrar un rol

            roleName = req.getParameter("deleteRole");

            try {
                rdi.deleteRole(roleName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("deleteUser") != null) {
            //Para borrar un usuario

            userName = req.getParameter("deleteUser");

            try {
                udi.deleteUser(userName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
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

        resp.sendRedirect("/index");

    }
}
