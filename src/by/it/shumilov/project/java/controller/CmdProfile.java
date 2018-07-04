package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.beans.Order;
import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

public class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;

        List<Avto> avtos = Dao.getDao().avto.getAll("");
        req.setAttribute("avtos",avtos);
        User user = (User) objUser;

        if (Util.isPost(req)) {
            if (req.getParameter("Update") != null) {
                String login = Util.getString(req, "login");
                String email = Util.getString(req, "email");
                String password = Util.getString(req, "password");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                Dao.getDao().user.update(user);
            }

        }



        String where = String.format(Locale.US, " WHERE `passports_id` IN (SELECT id FROM `passports` WHERE `users_id`=2)", user.getId());
        List<Order> orders = Dao.getDao().order.getAll(where);
        req.setAttribute("orders",orders);
        return null;
    }
}
