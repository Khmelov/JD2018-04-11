package by.it.sharin.jd03_04.java.controller;

import by.it.sharin.jd03_04.java.beans.User;
import by.it.sharin.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends by.it.sharin.jd03_04.java.controller.Cmd {
    @Override
    by.it.sharin.jd03_04.java.controller.Action execute(HttpServletRequest req) throws Exception {
        if (by.it.sharin.jd03_04.java.controller.Util.isPost(req)) {
            String login = by.it.sharin.jd03_04.java.controller.Util.getString(req, "login");
            String email = by.it.sharin.jd03_04.java.controller.Util.getString(req, "email");
            String password = by.it.sharin.jd03_04.java.controller.Util.getString(req, "password");
            if (login != null && email != null && password != null) {
                User user = new User(0, login, password, email, 2);
                Dao.getDao().user.create(user);
                if (user.getId() > 0)
                    return by.it.sharin.jd03_04.java.controller.Action.LOGIN;
            }
        }
        return null;
    }
}
