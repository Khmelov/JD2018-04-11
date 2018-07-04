package by.it.shekh.project.java.controller;

import by.it.shekh.project.java.beans.FacadeGeneral;
import by.it.shekh.project.java.beans.User;
import by.it.shekh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdAddFacade extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            String description = Util.getString(req, "description");
            String name = Util.getString(req, "name");
            String dimensions = Util.getString(req, "dimensions");
            double price = Util.getDouble(req, "price");
            String specs = Util.getString(req, "facade_specs");
            FacadeGeneral facadeGeneral = new FacadeGeneral(0,
                    name,
                    dimensions, description,
                    price, specs);
            Dao.getDao().facadeGeneral.create(facadeGeneral);
            return Action.INDEX;
        }
        return null;
    }
}
