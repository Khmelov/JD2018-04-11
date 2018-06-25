package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.Catalog;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdAddItem extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        if (Util.isPost(req)) {
            String name = req.getParameter("name");
            String price = req.getParameter("price");
            String amount = req.getParameter("amount");
            if (name != null && price != null && amount != null) {
                Catalog item = new Catalog(0, Integer.parseInt(amount), name, Double.parseDouble(price));
                DAO.getDao().catalog.create(item);
                if (item.getID() > 0)
                    return Actions.ADDCATALOGITEM;
            }
        }
        return null;
    }
}
