package by.it.kashayed.Project.java.controller;


import by.it.kashayed.Project.java.bean.Cars;
import by.it.kashayed.Project.java.bean.Owner;
import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oOwner = session.getAttribute("owner");
        if (oOwner == null)
            return Action.LOGIN;
       Owner owner = (Owner) oOwner;

        if (Util.isPost(req)) {
            if (req.getParameter("update") != null){
                String login = Util.getString(req, "Login");
                String email = Util.getString(req, "email");
                String password = Util.getString(req, "Password");
                String name = Util.getString(req, "Name");
                owner.setLogin(login);
                owner.setEmail(email);
                owner.setName(name);
                owner.setPass(password);
                Dao.getDao().owner.update(owner);
            }
            else if (req.getParameter("logout") != null) {
                session.invalidate();
                return Action.LOGIN;
            }
        }

        String where = String.format(Locale.US, " WHERE owner_id=%d", owner.getId());
        List<Cars> cars = Dao.getDao().cars.getAll(where);
        req.setAttribute("cars",cars);
        return null;
    }
}
