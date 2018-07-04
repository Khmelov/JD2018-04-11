package by.it.shumilov.project.java.controller;

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
        if(req.getParameter("logout") != null){
            session.invalidate();

            return Action.LOGIN;
        }

        User user = (User) objUser;
        String where = String.format(Locale.US, " WHERE users_id=%d", user.getId());
        List<Order> orders = Dao.getDao().order.getAll(where);
        req.setAttribute("orders",orders);
        return null;
    }
}
