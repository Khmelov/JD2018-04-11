package by.it.kashayed.Project.java.controller;

import by.it.kashayed.Project.java.bean.Owner;
import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "login");
            String pass = Util.getString(req, "password");
            if (login != null && pass != null) {
                String where = String.format(Locale.US,
                        "WHERE login='%s' AND password='%s'", login, pass);
                List<Owner> owners = Dao.getDao().owner.getAll(where);
                if (owners.size() > 0) {
                    Owner owner = owners.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("owner", owner);
                    return Action.PROFILE;
                }
            }
        }
        return null;
    }
}
