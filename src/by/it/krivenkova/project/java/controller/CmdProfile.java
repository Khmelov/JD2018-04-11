package by.it.krivenkova.project.java.controller;

import by.it.krivenkova.project.java.beans.Route;
import by.it.krivenkova.project.java.beans.User;
import by.it.krivenkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class CmdProfile extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Actions.LOGIN;
        User user = (User) oUser;

        if (Util.isPost(req)) {
            if (req.getParameter("update") != null){
                String login = Util.getString(req, "login");
                String email = Util.getString(req, "email");
                String password = Util.getString(req, "password");
                String surname = Util.getString(req, "surname");
                String name = Util.getString(req, "name");
                String patronymic = Util.getString(req, "patronymic");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                user.setName(name);
                user.setSurname(surname);
                user.setPatronymic(patronymic);
                Dao.getDao().user.update(user);
            }
            else if (req.getParameter("logout") != null) {
                session.invalidate();
                return Actions.LOGIN;
            }
        }

        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Route> routes = Dao.getDao().route.getAll(where);
        req.setAttribute("routes",routes);
        return null;
    }
}
