package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Catalog;
import by.it.obmetko.project.java.DAO.beens.Category;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.Actions;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandIndex extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        List<Catalog> catalogs = DAO.getDAO().catalogDAO.getAll("");
        req.setAttribute(Msg.CATEGORIES, categories);
        req.setAttribute(Msg.CATALOGS, catalogs);
        return Actions.INDEX.command;
    }
}