package by.it.kashayed.Project.java.controller;


import by.it.kashayed.Project.java.bean.Owner;
import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "Login");
            String email = Util.getString(req, "email");
            String pass = Util.getString(req, "Password");
            String name = Util.getString(req, "Name");
            if (login != null && email != null && pass != null) {
                Owner owner = new Owner(0, login, email, pass, null, 2);
                Dao.getDao().owner.create(owner);
                if (owner.getId() > 0) return Action.LOGIN;
            }
        }
        return null;
    }
}
