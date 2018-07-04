package by.it.krivenkova.project.java.controller;



import by.it.krivenkova.project.java.beans.Route;
import by.it.krivenkova.project.java.beans.User;
import by.it.krivenkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdCreateRoute /*extends Cmd*/ {
    /*@Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (Util.isPost(req)) {
                Route route = new Route();
                route.setDepTown(req.getParameter("name"));
                route.setDescription(req.getParameter("description"));
                route.setPrice(Double.parseDouble(req.getParameter("price")));



                route.setUsers_id((int) user.getId());
                Dao.getInstance().route.create(route);
            } else return null;
        }
        return Actions.PROFILE.cmd;
    }*/
}
