package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.Labrary;
import by.it.rogov.progect.java.beans.User;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

class CmdLabrary extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
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
        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Labrary> labrary = Dao.getDao().labrary.getAll(where);
        req.setAttribute("labrary",labrary);
        return null;
    }
}
