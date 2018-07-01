package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.Catalog;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdMyIndex extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        List<Catalog> items = DAO.getDao().catalog.getAll("");
        session.setAttribute("catalog", items);
        return new ActionResult("myindex");
    }
}
