package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.beans.Order;
import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CmdEditOrders extends  Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;
        else if(((User) objUser).getRoles_id() != 1)
            return Action.INDEX;
        List<Avto> avtos = dao.avto.getAll("");
        req.setAttribute("avtos",avtos);
        User user = (User) objUser;

        if (Util.isPost(req)) {

            String update = req.getParameter("Update");



            if(update!=null ){
                Long id = Util.getLong(req, "id");
                Date startorder = Util.getData(req,"startorder");
                Integer tenancy = Util.getInteger(req, "tenancy");
                Date endorder = Util.getData(req,"endorder");
                Double cost = Util.getDouble(req, "cost");
                Integer discount = Util.getInteger(req, "discount");
                Double realcost = Util.getDouble(req, "realcost");
                Long avtos_id = Util.getLong(req, "avtos_id");
                Long pasports_id = Util.getLong(req, "pasports_id");



                if (id!=null && startorder != null && tenancy != null && cost != null && discount != null && realcost != null && avtos_id != null ) {
                    Order order = new Order(id,startorder,tenancy,endorder,cost,discount,realcost,avtos_id,pasports_id);

                    dao.order.update(order);
                    return Action.EDITORDERS;

                }
            }
        }

        String where = String.format(Locale.US, " WHERE `endorder` IS NULL", user.getId());
        String whereEnd = String.format(Locale.US, " WHERE `endorder` IS NOT NULL", user.getId());

        List<Order> orders = dao.order.getAll(where);
        List<Order> ordersEnd = dao.order.getAll(whereEnd);

        req.setAttribute("orders",orders);
        req.setAttribute("ordersend",ordersEnd);
        req.setAttribute("passports", dao.passport.getAll(""));
        return null;
    }
}
