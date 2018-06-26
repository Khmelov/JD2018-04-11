package by.it.mokhart.project.java.controller;

import by.it.mokhart.project.java.beans.User;
import by.it.mokhart.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws Exception {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            if (login != null && email != null && password != null) {
                User user = new User(0, login, password, email, 2);
                Dao.getDao().user.create(user);
                if (user.getId() > 0)
                    return Actions.LOGIN;
            }
        }
        return null;
    }
}
