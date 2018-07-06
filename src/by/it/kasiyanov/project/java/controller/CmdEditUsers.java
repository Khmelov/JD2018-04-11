package by.it.kasiyanov.project.java.controller;

import by.it.kasiyanov.project.java.beans.Roles;
import by.it.kasiyanov.project.java.beans.User;
import by.it.kasiyanov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)){
            Long id = Util.getLong(req,"id");
            String login = Util.getString(req, "login");
            String email = Util.getEmail(req, "email");
            String password = Util.getString(req, "password");
            Long rolesId = Util.getLong(req, "roles_id");
            User user = new User(id, login, password, email, rolesId);
            if (req.getParameter("Update") != null){
                dao.user.update(user);
            }
            else if (req.getParameter("Delete") != null){
                dao.user.delete(user);
            }
        }
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", users);
        List<Roles> roles = dao.roles.getAll("");
        req.setAttribute("roles", roles);
        return null;
    }
}
