package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

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
        String where = String.format(Locale.US, " , `permissions`, `users` " +
                        "WHERE users.id=%d " +
                        "AND publications.id=permissions.publications_id " +
                        "AND permissions.users_id=users.id AND permissions.access=true",
                user.getId());
        List<Publication> publications = Dao.getDao().publication.getAll(where);
        req.setAttribute("publications",publications);
        return null;
    }
}
