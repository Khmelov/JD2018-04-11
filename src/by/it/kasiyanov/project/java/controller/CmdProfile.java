package by.it.kasiyanov.project.java.controller;

import by.it.kasiyanov.project.java.beans.TravelOffers;
import by.it.kasiyanov.project.java.beans.User;
import by.it.kasiyanov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null){
            return Action.LOGIN;
        }

        User user = (User) oUser;

        if (Util.isPost(req)){
            if (req.getParameter("update") != null){
                String login = Util.getString(req, "login");
                String email = Util.getEmail(req, "email");
                String password = Util.getString(req, "password");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                Dao.getDao().user.update(user);
            }
            else if (req.getParameter("logout") != null){
                session.invalidate();
                return Action.LOGIN;
            }
        }


        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<TravelOffers> travelOffers = Dao.getDao().travelOffers.getAll(where);
        req.setAttribute("travelOffers", travelOffers);
        return null;
    }
}
