package by.it.lanevich.project.java.controller;

import by.it.lanevich.project.java.beans.Order;
import by.it.lanevich.project.java.beans.User;
import by.it.lanevich.project.java.dao.Dao;

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
                String phone = Util.getString(req, "phone");
                String address = Util.getString(req, "address");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                user.setPhone(phone);
                user.setAddress(address);
                Dao.getDao().user.update(user);
            }
            else if (req.getParameter("logout") != null) {
                session.invalidate();
                return Action.LOGIN;
            }
        }

        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Order> orders = Dao.getDao().order.getAll(where);
        req.setAttribute("orders",orders);
        return null;
    }
}
