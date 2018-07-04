package by.it.shekh.project.java.controller;

import by.it.shekh.project.java.beans.Role;
import by.it.shekh.project.java.beans.User;
import by.it.shekh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            long id = Util.getLong(req, "id_users");
            System.out.println(id);
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            long rolesId = Util.getLong(req, "id_roles");
            System.out.println(rolesId);
            User user = new User(id, login, password, email, rolesId);
            if (req.getParameter("Update") != null) {
                /*user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);*/
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
