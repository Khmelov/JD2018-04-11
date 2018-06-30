package by.it.mokhart.project.java.controller;

import by.it.mokhart.project.java.beans.Ad;
import by.it.mokhart.project.java.beans.User;
import by.it.mokhart.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreateAd extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Actions.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            String description = Util.getString(req, "description");
            double price = Util.getDouble(req, "price");
            String size = Util.getString(req, "size");
            String fabric = Util.getString(req, "fabric");
            String colour = Util.getString(req, "colour");
            String sex = Util.getString(req, "sex");
            String producer = Util.getString(req, "producer");
            Ad ad = new Ad(0,
                    description,
                    price, size,
                    fabric, colour,
                    sex, producer,
                    user.getId());
            Dao.getDao().ad.create(ad);
            return Actions.PROFILE;
        }
        return null;
    }
}