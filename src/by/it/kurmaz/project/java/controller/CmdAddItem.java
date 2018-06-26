package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.Catalog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class CmdAddItem extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (Util.isPost(req)) {
            String name = Util.getString(req,"name");
            double price = Util.getDouble(req, "price");
            int amount = Util.getInteger(req, "amount");
            if (name != null) {
                Catalog item = new Catalog(0, amount, name, price);
                DAO.getDao().catalog.create(item);
                if (item.getID() > 0)
                    return null;
            }
        }
        return null;
    }
}
