package by.it.obmetko.project.java.commands.crud;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Catalog;
import by.it.obmetko.project.java.DAO.beens.Category;
import by.it.obmetko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandCrudCategories extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        if (FormUtil.isPost(req)) {
            Category category=new Category(FormUtil.getInt(req.getParameter("id")),
                                       FormUtil.getString(req.getParameter("categoryName"),Pattern.CATEGORY),
                                        FormUtil.getInt(req.getParameter("Catalog_id")));


            if (req.getParameter("Update") != null) {
                DAO.getDAO().categoryDAO.update(category);
            } else if (req.getParameter("Delete") != null) {
                DAO.getDAO().categoryDAO.delete(category);
            } else if (req.getParameter("Create") != null) {
                DAO.getDAO().categoryDAO.create(category);
            }
        }


        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        List<Catalog> catalogs = DAO.getDAO().catalogDAO.getAll("");
        req.setAttribute(Msg.CATEGORIES, categories);
        req.setAttribute(Msg.CATALOGS, catalogs);
        return Actions.CRUDCATEGORIES.command;
    }
}