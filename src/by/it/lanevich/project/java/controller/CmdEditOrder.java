package by.it.lanevich.project.java.controller;


import by.it.lanevich.project.java.beans.Order;
import by.it.lanevich.project.java.beans.User;
import by.it.lanevich.project.java.beans.Good;
import by.it.lanevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdEditOrder extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
//            String where = String.format(Locale.US, " WHERE id='%d'", Util.getLong(req,"goods"));
//            List<Good> goods = dao.good.getAll(where);
//            if (goods.size()>0)
//                req.setAttribute("goods", goods.get(0));
            Long id = Util.getLong(req, "id");
            Long ord_id = Util.getLong(req, "ord_id");
            Long numgood = Util.getLong(req, "numgood");
            Long usersId = Util.getLong(req, "users_id");
            Long goodsId = Util.getLong(req, "goods_id");
            Order order = new Order(id,
                    ord_id,
                    numgood,
                    usersId,
                    //                        good.getId()); //TODO вставить ид выбранного товара
                    goodsId);
            //      2);
            if (req.getParameter("submit") != null) {
                dao.order.create(order);
                return Action.PROFILE;
            } else if (req.getParameter("Update") != null) {
                dao.order.update(order);
            } else if (req.getParameter("Delete") != null) {
                dao.order.delete(order);
            }
        }
        List<Order> orders = dao.order.getAll("");
        req.setAttribute("orders", orders);
        List<Good> goods = dao.good.getAll("");
        req.setAttribute("goods", goods);

        return null;
    }
}
