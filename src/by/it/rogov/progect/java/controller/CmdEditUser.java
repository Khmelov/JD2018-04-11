package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.Role;
import by.it.rogov.progect.java.beans.User;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUser extends  Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        if(Util.isPost(req)){
            Long id = Util.getLONG(req, "id");
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            Long rolesId = Util.getLONG(req, "roles_id");
            User user = new User(id, login, password, email, rolesId);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            } else if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }
        }
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", users);
        List<Role> roles = dao.role.getAll("");
        req.setAttribute("roles", roles);


        return null;
    }
}
