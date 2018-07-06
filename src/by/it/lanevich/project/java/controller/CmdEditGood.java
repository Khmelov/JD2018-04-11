package by.it.lanevich.project.java.controller;

import by.it.lanevich.project.java.beans.Good;
import by.it.lanevich.project.java.beans.User;
import by.it.lanevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdEditGood extends Cmd{

    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Dao dao = Dao.getDao();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            Long id=Util.getLong(req, "id");
            Long idgood = Util.getLong(req, "idgood");
            String goodname = Util.getString(req, "goodname");
            String description = Util.getString(req, "description");
            int piecies = Util.getInteger(req, "piecies");
            int price = Util.getInteger(req, "price");
            Good good = new Good(id,
                    idgood,
                    goodname,
                    description,
                    piecies,
                    price);
            if (req.getParameter("submit") != null) {
                dao.good.create(good);
                 } else if (req.getParameter("Update") != null) {
                dao.good.update(good);
            } else if (req.getParameter("Delete") != null) {
                dao.good.delete(good);
            }

        }
        List<Good> goods = Dao.getDao().good.getAll("");
        req.setAttribute("goods", goods);
        return null;
    }

}
