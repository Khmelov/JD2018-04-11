package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;

        if (Util.isPost(req)) {
            if (req.getParameter("logout") != null) {
                session.invalidate();
                return Action.LOGIN;
            }
        }

        User user = (User) oUser;
        //String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        //List<Ad> ads = Dao.getDao().ad.getAll(where);
        //req.setAttribute("ads",ads);
        return null;
    }
}
