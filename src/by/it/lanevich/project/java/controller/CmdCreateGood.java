package by.it.lanevich.project.java.controller;

import by.it.lanevich.project.java.beans.Order;
import by.it.lanevich.project.java.beans.User;
import by.it.lanevich.project.java.beans.Good;
import by.it.lanevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdCreateGood extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        List<Good> goods = Dao.getDao().good.getAll("");
        req.setAttribute("goods", goods);
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            long idgood = Util.getLong(req, "idgood");
            String goodname = Util.getString(req, "goodname");
            String description = Util.getString(req, "description");
            int piecies = Util.getInteger(req, "piecies");
            int price = Util.getInteger(req, "price");
            Good good = new Good(0,
                    idgood,
                    goodname,
                    description,
                        piecies,
                      price);
            Dao.getDao().good.create(good);
            return Action.PROFILE;
        }
        return null;
    }
}
