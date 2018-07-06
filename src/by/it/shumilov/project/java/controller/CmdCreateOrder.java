package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.beans.Order;
import by.it.shumilov.project.java.beans.Passport;
import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CmdCreateOrder extends  Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = null;
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser != null){
            user = (User) objUser;
//            String json = new Gson().toJson(Dao.getDao().
//                                    passport.getAll( String.format(Locale.US,"where id='%d'", user.getId())));
            List<Passport> allPass = Dao.getDao().passport.getAll(String.format(Locale.US, "where users_id='%d'", user.getId()));
            req.setAttribute("pass",allPass);
        }
        else {
            return Action.LOGIN;
        }
        if(Util.isPost(req)) {

            String where = String.format(Locale.US, " WHERE id='%d'", Util.getLong(req,"AddAvto"));
            List<Avto> avto = Dao.getDao().avto.getAll(where);
            if (avto.size()>0)
                req.setAttribute("avto",avto.get(0));


            //System.out.println(req.getAttribute("startorder").toString()+"atr");
            Long id = Util.getLong(req, "id");

            Date startorder = Util.getData(req,"startorder");

            Integer tenancy = Util.getInteger(req, "tenancy");

            Double cost = Util.getDouble(req, "cost");

            Integer discount = Util.getInteger(req, "discount");

            Double realcost = Util.getDouble(req, "realcost");

            Long avtos_id = Util.getLong(req, "avtos_id");

            Long pasports_id = Util.getLong(req, "pasports_id");




            if (startorder != null && tenancy != null && cost != null && discount != null && realcost != null && avtos_id != null ) {
                Order order = new Order(0,startorder,tenancy,null,cost,discount,realcost,avtos_id,pasports_id);
                System.out.println(order);
                if (req.getParameter("Update") != null) {
                    dao.order.update(order);
                } else if (req.getParameter("Delete") != null) {
                    dao.order.delete(order);
                } else  if (req.getParameter("Add") != null) {
                    dao.order.create(order);
                    return  Action.PROFILE;
                }
//                if(avto.getId() > 0)
//
//                    req.setAttribute("avto", avto);
                //return  Action.CREATEAVTO;
            }


        }


        return null;
    }
}
