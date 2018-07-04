package by.it.sharin.jd03_04.java.controller;


import by.it.sharin.jd03_04.java.beans.Ad;
import by.it.sharin.jd03_04.java.beans.User;
import by.it.sharin.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreateAd extends by.it.sharin.jd03_04.java.controller.Cmd {
    @Override
    by.it.sharin.jd03_04.java.controller.Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return by.it.sharin.jd03_04.java.controller.Action.LOGIN;
        User user = (User) oUser;
        if (by.it.sharin.jd03_04.java.controller.Util.isPost(req)) {
            String marka = by.it.sharin.jd03_04.java.controller.Util.getString(req, "marka");
            String model = by.it.sharin.jd03_04.java.controller.Util.getString(req, "model");
            double price = by.it.sharin.jd03_04.java.controller.Util.getDouble(req, "price");
            Ad ad = new Ad(0,
                    marka,
                    price, model,
                    user.getId());
            Dao.getDao().ad.create(ad);
            return by.it.sharin.jd03_04.java.controller.Action.PROFILE;
        }
        return null;
    }
}
