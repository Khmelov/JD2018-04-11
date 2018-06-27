package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (Util.isPost(req)) {
            String login = Util.getLogin(req, "login");
            String password = Util.getString(req, "password");
            if (login != null && password != null) {
                String where = String.format(Locale.US,
                        " WHERE login='%s' AND password='%s' ",
                        login, password);
                List<User> users = Dao.getDao().user.getAll(where);
                if (users.size() > 0) {
                    User user = users.get(0);
                    req.setAttribute("user", user);
                }
            }
        }
        return null;
    }
}
