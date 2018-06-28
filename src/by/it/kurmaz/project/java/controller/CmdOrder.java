package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.Catalog;
import by.it.kurmaz.project.java.beans.Order;
import by.it.kurmaz.project.java.beans.ShippingList;
import by.it.kurmaz.project.java.beans.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdOrder extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null)
            return new ActionResult(Actions.INDEX);
        if (Util.isPost(req)) {
            Object isUser = session.getAttribute("user");
            Object isOrder = session.getAttribute("order");
            if (isUser != null) {
                User user = (User) isUser;
                int user_id = (int) user.getId();
                String name = Util.getString(req, "select");
                String amount = Util.getString(req, "amount");
                long order_id;
                if (isOrder != null) {
                    Order order = (Order) isOrder;
                    order_id = order.getId();
                }
                else {
                    Order order = new Order(0, 0, user_id);
                    DAO.getDao().order.create(order);
                    session.setAttribute("order", order);
                    order_id = order.getId();
                }
                if (name != null && amount != null) {
                    String sql = String.format(Locale.US, "WHERE `NAME`='%s'", name);
                    List<Catalog> catalogList = DAO.getDao().catalog.getAll(sql);
                    Catalog item = catalogList.get(0);
                    int itemID = (int) item.getID();
                    ShippingList list = new ShippingList(0, amount, itemID, (int) order_id);
                    DAO.getDao().shippingList.create(list);
                }
            }
        }
        return null;
    }
}
