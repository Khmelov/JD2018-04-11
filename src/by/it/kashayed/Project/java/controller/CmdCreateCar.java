package by.it.kashayed.Project.java.controller;


import by.it.kashayed.Project.java.bean.Cars;
import by.it.kashayed.Project.java.bean.Owner;
import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreateCar extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("owner");
        if (oUser == null)
            return Action.LOGIN;
        Owner user = (Owner) oUser;
        if (Util.isPost(req)) {
            String model = Util.getString(req, "model");
            int year = Util.getInteger(req, "year");
            String color = Util.getString(req, "color");
            double vengine = Util.getInteger(req, "vengine");
            double price = Util.getDouble(req, "price");
            Cars ad = new Cars(0,
                    model,
                    year, color,
                    vengine, price,
                    user.getId());
            Dao.getDao().cars.create(ad);
            return Action.PROFILE;
        }
        return null;
    }
}
