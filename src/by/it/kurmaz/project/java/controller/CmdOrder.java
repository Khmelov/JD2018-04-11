package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.Order;
import by.it.kurmaz.project.java.beans.ShippingList;
import by.it.kurmaz.project.java.connection.dbConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

class CmdOrder extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        if (Util.isPost(req)) {
            String name = Util.getString(req,"select");
            String amount = Util.getString(req,"amount");
            int id = Util.getInteger(req, "user_id");
            if (name != null && amount != null) {
                Order order = new Order(0, 0, id);
                DAO.getDao().order.create(order);
                long order_id = order.getId();
                String sql = String.format(Locale.US, "" + "SELECT `ID` FROM `catalog` WHERE `NAME`='%s'", name);
                ResultSet resultSet = dbConnection.getConnection().createStatement().executeQuery(sql);
                int catalog_id = 0;
                if (resultSet.next())
                    catalog_id = resultSet.getInt(1);
                ShippingList list = new ShippingList(0, amount, catalog_id, (int)order_id);
                DAO.getDao().shippingList.create(list);
                if (list.getId() > 0) {
                    PrintWriter respWriter = resp.getWriter();
                    respWriter.println("Order created! <br>");
                }
                return new ActionResult(Actions.VIEWCATALOG);
            }
        }
        return null;
    }
}
