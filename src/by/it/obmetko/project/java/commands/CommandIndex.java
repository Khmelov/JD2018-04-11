package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.CatalogDAO;
import by.it.obmetko.project.java.DAO.CategoryDAO;
import by.it.obmetko.project.java.DAO.beens.Catalog;
import by.it.obmetko.project.java.DAO.beens.Category;
import by.it.obmetko.project.java.controller.Action;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandIndex extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {      List<Catalog> catalogs = new CatalogDAO().getAll("");
        List<Category> categories = new CategoryDAO().getAll("");

        req.setAttribute(Msg.CATALOGS, catalogs);
        req.setAttribute(Msg.CATEGORIES, categories);
        return Action.INDEX.command;
    }
}