package by.test.SCAND.java.controller;


import by.test.SCAND.java.bean.Goods;
import by.test.SCAND.java.bean.User;
import by.test.SCAND.java.dao.Dao;

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
            String name = Util.getString(req, "name");
            //Object photo = Util.getObject(req, "photo");
            Double price = Util.getDouble(req, "price");
            if(price==null){
                price=0.1;
            }
            Goods goods = new Goods(0,name,
                      description, price,"1",

                    user.getIduser());
            Dao.getDao().goods.create(goods);
            return Actions.PROFILE;
        }

            return null;


    }
}
