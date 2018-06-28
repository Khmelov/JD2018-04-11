package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdLogin extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req , HttpServletResponse resp) throws SQLException {
        if (Util.isPost(req)) {
            String login = Util.getString(req,"login");
            String password = Util.getString(req,"password");
            if (login != null && password != null) {
                String where = String.format(Locale.US,
                        " WHERE login='%s' AND password='%s' ",
                        login, password);
                List<User> users = DAO.getDao().user.getAll(where);
                if (users.size() > 0) {
                    User user = users.get(0);
                    req.setAttribute("user", user);
                    return new ActionResult("user");
                }
            }
        }
        return null;
    }
}
