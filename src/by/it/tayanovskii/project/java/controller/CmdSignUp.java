package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Util.isPost(req)) {
            String login = Util.getLogin(req, "login");
            String email = Util.getEmail(req, "email");
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
