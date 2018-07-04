package by.it.shekh.project.java.controller;


import by.it.shekh.project.java.beans.User;
import by.it.shekh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String pass = Util.getString(req, "password");
            if (login != null && email != null && pass != null) {
                User user = new User(0, login, pass, email, 2);
                Dao.getDao().user.create(user);
                if (user.getId() > 0)
                    return Action.LOGIN;
            }
        }
        return null;
    }
}
