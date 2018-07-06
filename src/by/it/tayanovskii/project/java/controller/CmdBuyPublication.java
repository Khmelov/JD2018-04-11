package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Permission;
import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class CmdBuyPublication extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (user.getRoles_id() == 1)
            return Action.PROFILE;
        if (Util.isPost(req)) {
            Long publications_id = Util.getLong(req, "id");
            Permission permission = new Permission(0, true, user.getId(), publications_id);
            if (req.getParameter("Buy") != null) {
                dao.permission.create(permission);
            }
        }
        List<Publication> publications = dao.publication.getAll("");
        req.setAttribute("publications", publications);
        return null;
    }
}
