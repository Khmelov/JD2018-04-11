package by.it.krivenkova.project.java.controller;



import by.it.krivenkova.project.java.beans.Route;
import by.it.krivenkova.project.java.beans.User;
import by.it.krivenkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdCreateRoute extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Actions.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            String depTown = Util.getString(req, "depTown");
            String depDate = Util.getString(req, "depDate");
            String depTime = Util.getString(req, "depTime");
            String arrTown = Util.getString(req, "arrTown");
            double price = Util.getDouble(req, "price");
            int numTickets = Util.getInteger(req, "numTickets");
            Route route = new Route(0,
                    depTown,
                    depDate, depTime,
                    arrTown,
                    price, numTickets,
                    user.getId());
            Dao.getDao().route.create(route);
            return Actions.PROFILE;
        }
        return null;
    }
}
