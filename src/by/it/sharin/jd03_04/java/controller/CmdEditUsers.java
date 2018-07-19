package by.it.sharin.jd03_04.java.controller;


import by.it.sharin.jd03_04.java.beans.Role;
import by.it.sharin.jd03_04.java.beans.User;
import by.it.sharin.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends by.it.sharin.jd03_04.java.controller.Cmd {
    @Override
    by.it.sharin.jd03_04.java.controller.Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (by.it.sharin.jd03_04.java.controller.Util.isPost(req)) {
            Long id = by.it.sharin.jd03_04.java.controller.Util.getLong(req, "id");
            String login = by.it.sharin.jd03_04.java.controller.Util.getString(req, "login");
            String email = by.it.sharin.jd03_04.java.controller.Util.getString(req, "email");
            String password = by.it.sharin.jd03_04.java.controller.Util.getString(req, "password");
            Long rolesId = by.it.sharin.jd03_04.java.controller.Util.getLong(req, "roles_id");
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
