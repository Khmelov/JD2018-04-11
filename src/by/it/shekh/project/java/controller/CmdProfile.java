package by.it.shekh.project.java.controller;

import by.it.shekh.project.java.beans.FacadeGeneral;
import by.it.shekh.project.java.beans.User;
import by.it.shekh.project.java.dao.Dao;

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
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;

        if (Util.isPost(req)) {
            if (req.getParameter("update") != null){
                String login = Util.getString(req, "login");
                String email = Util.getString(req, "email");
                String password = Util.getString(req, "password");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                Dao.getDao().user.update(user);
            }
            else if (req.getParameter("logout") != null) {
                session.invalidate();
                return Action.LOGIN;
            }
        }

        List<FacadeGeneral> facades = Dao.getDao().facadeGeneral.getAll("");
        req.setAttribute("facades",facades);
        return null;
    }
}
