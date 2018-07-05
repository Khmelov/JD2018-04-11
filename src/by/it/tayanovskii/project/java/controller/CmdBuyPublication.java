package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.beans.User;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdBuyPublication extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if(user.getRoles_id()!=1)
            return Action.LOGIN;
        if (Util.isPost(req)) {
            Long id = Util.getLong(req, "id");
            String title = Util.getString(req, "title");
            Integer number = Util.getInteger(req, "number");
            String date = Util.getString(req, "date");
            String description = Util.getString(req, "description");
            Double price = Util.getDouble(req, "price");
            Publication publication = new Publication(id, title, number, date, description, price);
            if (req.getParameter("Update") != null) {
                dao.publication.update(publication);
            } else if (req.getParameter("Delete") != null) {
                dao.publication.delete(publication);
            }
        }
        List<Publication> publications = dao.publication.getAll("");
        req.setAttribute("publications", publications);
        return null;
    }
}
