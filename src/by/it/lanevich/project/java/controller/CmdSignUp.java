package by.it.lanevich.project.java.controller;

import by.it.lanevich.project.java.beans.User;
import by.it.lanevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            String phone = Util.getString(req, "phone");
            String address = Util.getString(req, "address");
            if (login != null && email != null && password != null) {
                User user = new User(0, login, password, email, phone, address, 2);
                Dao.getDao().user.create(user);
                if (user.getId() > 0)
                    return Action.LOGIN;
            }
        }
        return null;
    }
}
