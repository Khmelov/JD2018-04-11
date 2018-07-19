package by.it.akhmelev.project08.java.controller;


import by.it.akhmelev.project08.java.beans.Role;
import by.it.akhmelev.project08.java.beans.User;
import by.it.akhmelev.project08.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            Long id = Util.getLong(req, "id");
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            Long rolesId = Util.getLong(req, "roles_id");
            User user = new User(id, login, password, email, rolesId);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            } else if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }
        }
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", users);
        return null;
    }
}
