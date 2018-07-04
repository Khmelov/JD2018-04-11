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
        Object oOwner = session.getAttribute("owner");
        if (oOwner == null)
            return Action.LOGIN;
        Owner owner = (Owner) oOwner;
        if (Util.isPost(req)) {
            String model = Util.getString(req, "model");
            int year = Util.getInteger(req, "year");
            String color = Util.getString(req, "color");
            double vengine = Util.getDouble(req, "vengine");
            double price = Util.getDouble(req, "price");
            Cars cars = new Cars(0,model,year,color,vengine,price,owner.getId());
            Dao.getDao().cars.create(cars);
            return Action.PROFILE;
        }
        return null;
    }
}
