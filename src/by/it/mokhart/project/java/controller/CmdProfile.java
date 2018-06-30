package by.it.mokhart.project.java.controller;

import by.it.mokhart.project.java.beans.Ad;
import by.it.mokhart.project.java.beans.User;
import by.it.mokhart.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdProfile extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Actions.LOGIN;

        if (Util.isPost(req)) {
            if (req.getParameter("logout") != null) {
                session.invalidate();
                return Actions.LOGIN;
            }
        }

        User user = (User) oUser;
        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Ad> ads = Dao.getDao().ad.getAll(where);
        req.setAttribute("ads",ads);
        return null;
    }
}
