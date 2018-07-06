package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.beans.Order;
import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
                //String password = Util.getString(req, "password");
                if(login!=null && email!=null ){
                    user.setLogin(login);
                    user.setEmail(email);
                    //user.setPassword(DigestUtils.sha256Hex(password));
                    dao.user.update(user);

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
