package by.it.tarasiuk.project.java.controller;

import by.it.tarasiuk.project.java.beans.Advert;
import by.it.tarasiuk.project.java.beans.User;
import by.it.tarasiuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if (objUser == null)
            return Action.LOGIN;

        User user = (User) objUser;

        if (Util.isPost(req)) {
            if (req.getParameter("update") != null) {
                String login = Util.getString(req, "login");
                String password = Util.getString(req, "password");
                String email = Util.getString(req, "email");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                Dao.getDao().user.update(user);
            } else if (req.getParameter("logout") != null) {
                session.invalidate();
                return Action.LOGIN;
            }
        }

        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Advert> adverts = Dao.getDao().advert.getAll(where);
        req.setAttribute("adverts", adverts);
        return null;
    }
}
