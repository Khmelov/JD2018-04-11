package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Permission;
import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdSetPermission extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (user.getRoles_id() != 1)
            return Action.SETPERMISSION;
        if (Util.isPost(req)) {
            Long publications_id = Util.getLong(req, "publications_id");
            Long users_id = Util.getLong(req, "users_id");
            if (req.getParameter("SetTrue") != null) {
                Permission permission = new Permission(0, true, users_id, publications_id);
                dao.permission.create(permission);
            }
            if (req.getParameter("SetFalse") != null) {
                Permission permission = new Permission(0, false, users_id, publications_id);
                dao.permission.create(permission);
            }
        }
        List<Publication> publications = dao.publication.getAll("");
        List<User> users = dao.user.getAll("");
        req.setAttribute("publications", publications);
        req.setAttribute("users",users);
        return null;
    }
}
