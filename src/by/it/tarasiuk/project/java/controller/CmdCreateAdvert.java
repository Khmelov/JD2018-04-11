package by.it.tarasiuk.project.java.controller;

import by.it.tarasiuk.project.java.beans.User;
import by.it.tarasiuk.project.java.beans.Advert;
import by.it.tarasiuk.project.java.dao.Dao;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreateAdvert extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            String brand = Util.getString(req, "brand");
            String model = Util.getString(req, "model");
            int year = Util.getInteger(req, "year");
            String type = Util.getString(req, "type");
            String grade = Util.getString(req, "grade");
            String color = Util.getString(req, "color");
            double price = Util.getDouble(req, "price");
            String description = Util.getString(req, "description");
            Advert advert = new Advert(0,
                    brand, model, year,
                    type, grade, color,
                    price, description,
                    user.getId());
            Dao.getDao().advert.create(advert);
            return Action.PROFILE;
        }
        return null;
    }
}
