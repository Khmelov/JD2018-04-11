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

public class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;

        List<Avto> avtos = dao.avto.getAll("");
        req.setAttribute("avtos",avtos);
        User user = (User) objUser;

        if (Util.isPost(req)) {
            if (req.getParameter("UpdateUser") != null) {
                String login = Util.getString(req, "login");
                String email = Util.getEmail(req, "email");

                if(login!=null && email!=null ){
                    user.setLogin(login);
                    user.setEmail(email);

                    dao.user.update(user);

                }
            }
            String update = req.getParameter("Update");

            String delete = req.getParameter("Delete");

            if(update!=null || delete!=null){
                Long id = Util.getLong(req, "id");

                Date startorder = Util.getData(req,"startorder");
                Integer tenancy = Util.getInteger(req, "tenancy");
                Double cost = Util.getDouble(req, "cost");
                Integer discount = Util.getInteger(req, "discount");
                Double realcost = Util.getDouble(req, "realcost");
                Long avtos_id = Util.getLong(req, "avtos_id");
                Long pasports_id = Util.getLong(req, "pasports_id");



                if (id!=null && startorder != null && tenancy != null && cost != null && discount != null && realcost != null && avtos_id != null ) {
                    Order order = new Order(id,startorder,tenancy,null,cost,discount,realcost,avtos_id,pasports_id);


                    if (update != null) {
                        dao.order.update(order);
                    } else if (delete != null) {
                        dao.order.delete(order);

                    }

                }
            }
        }

        String where = String.format(Locale.US, " WHERE passports_id IN (SELECT id FROM passports WHERE users_id=%d)  AND `endorder` IS NULL", user.getId());
        String whereEnd = String.format(Locale.US, " WHERE passports_id IN (SELECT id FROM passports WHERE users_id=%d)  AND `endorder` IS NOT NULL", user.getId());

        List<Order> orders = dao.order.getAll(where);
        List<Order> ordersEnd = dao.order.getAll(whereEnd);

        req.setAttribute("orders",orders);
        req.setAttribute("ordersend",ordersEnd);
        req.setAttribute("passports", dao.passport.getAll(String.format(Locale.US, "WHERE users_id=%d",  user.getId())));
        return null;
    }
}
