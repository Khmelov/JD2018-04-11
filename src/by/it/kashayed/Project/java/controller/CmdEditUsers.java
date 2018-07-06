package by.it.kashayed.Project.java.controller;

import by.it.kashayed.Project.java.bean.Owner;
import by.it.kashayed.Project.java.bean.Owners;
import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            Integer id = Util.getInteger(req, "id");
            String login = Util.getString(req, "Login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "Password");
            String name = Util.getString(req, "Name");
            Integer ownersId = Util.getInteger(req, "owners_id");
            Owner owner = new Owner(id, login, email,password, name, ownersId);
            if (req.getParameter("Update") != null) {
                dao.owner.update(owner);
            } else if (req.getParameter("Delete") != null) {
                dao.owner.delete(owner);
            }
        }
        List<Owner> users = dao.owner.getAll("");
        req.setAttribute("owner", users);
        List<Owners> roles = dao.owners.getAll("");
        req.setAttribute("roles", roles);
        return null;
    }
}
