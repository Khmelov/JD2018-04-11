package by.it.sharin.jd03_04.java.controller;

import by.it.sharin.jd03_04.java.beans.Ad;
import by.it.sharin.jd03_04.java.beans.User;
import by.it.sharin.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdProfile extends by.it.sharin.jd03_04.java.controller.Cmd {
    @Override
    by.it.sharin.jd03_04.java.controller.Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return by.it.sharin.jd03_04.java.controller.Action.LOGIN;

        if (by.it.sharin.jd03_04.java.controller.Util.isPost(req)) {
            if (req.getParameter("logout") != null) {
                session.invalidate();
                return by.it.sharin.jd03_04.java.controller.Action.LOGIN;
            }
        }

        User user = (User) oUser;
        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Ad> ads = Dao.getDao().ad.getAll(where);
        req.setAttribute("ads",ads);
        return null;
    }
}
