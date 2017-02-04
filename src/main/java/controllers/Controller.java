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
public class Controller extends HttpServlet{


    private List<User> userList = new ArrayList<User>();
    private List<Role> roleList = new ArrayList<Role>();
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    UserDaoImplements udi = (UserDaoImplements)beans.getBean("userDaoImp");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        String user_name = req.getParameter("name");
        String user_pass = req.getParameter("pass");
        String[] roles = req.getParameterValues("role");

        try {
            udi.insertUser(user_name, user_pass, roles);
            resp.sendRedirect("/index");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
