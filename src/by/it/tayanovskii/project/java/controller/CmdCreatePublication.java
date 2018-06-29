package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreatePublication extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        // control user`s, who create publication
        if (user.getRoles_id()!=1) {
            return Action.ERROR;
        }
        if (Util.isPost(req)) {
            String title = Util.getString(req, "title");
            int number = Util.getInteger(req, "number");
            String date = Util.getString(req, "date");
            String description = Util.getString(req, "description");
            double price = Util.getDouble(req, "price");
            Publication publication = new Publication(0,title,number,date,description,price);
            Dao.getDao().publication.create(publication);
            return Action.PROFILE;
        }
        return null;
    }

}
