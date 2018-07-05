package by.it.lanevich.project.java.controller;


import by.it.lanevich.project.java.beans.Order;
import by.it.lanevich.project.java.beans.User;
import by.it.lanevich.project.java.beans.Good;
import by.it.lanevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdCreateOrder extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        List<Order> orders = Dao.getDao().order.getAll("");
        req.setAttribute("orders", orders);
        List<Good> goods = Dao.getDao().good.getAll("");
        req.setAttribute("goods", goods);
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            long ord_id = Util.getLong(req, "ord_id");
            long numgood = Util.getLong(req, "numgood");
                 Order order = new Order(0,
                         ord_id,
                         numgood,
                    user.getId(),
//                         good.getId()); //TODO вставить ид выбранного товара
        2);
            Dao.getDao().order.create(order);
            return Action.PROFILE;
        }
        return null;
    }
}
