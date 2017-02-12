package filters;

import dao.RoleDaoImplements;
import dao.UserDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by Joshua on 12/02/2017.
 */
// Implements Filter class
public class AdminFilter implements Filter {
    public void init(FilterConfig config)
            throws ServletException {
    }

    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String name = request.getUserPrincipal().getName();
        ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
        UserDaoImplements udi = (UserDaoImplements) beans.getBean("userDaoImp");
        boolean admin = false;
        String roleName = "admin";

        try {
            User user = udi.findUser(name, true);
            for(Role role : user.getRoles()) {
                if(role.getRoleName().equals(roleName)) {
                    admin = true;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Pass request back down the filter chain
        req.setAttribute("admin", admin);
        chain.doFilter(req, resp);



    }

    public void destroy() {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
