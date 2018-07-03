package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.User;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            if (login != null && email != null && password != null) {
                User user = new User(0, login, password, email, 2);
                Dao.getDao().user.create(user);
                if (user.getId() > 0)
                    return Action.LOGIN;
            }
        }
        return null;
    }
}
