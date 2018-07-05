package by.it.obmetko.project.java.commands.crud;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Catalog;
import by.it.obmetko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;



public class CommandCrudCatalogs  extends ActionCommand  {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {
            Catalog catalog=new Catalog(FormUtil.getInt(req.getParameter("id")),
                    FormUtil.getString(req.getParameter("catalogName"),Pattern.CATALOG));
            if(req.getParameter("Update")!=null){
                DAO.getDAO().catalogDAO.update(catalog);
            }else if(req.getParameter("Delete")!=null){
                DAO.getDAO().catalogDAO.delete(catalog);
            }else if(req.getParameter("Create")!=null){
                DAO.getDAO().catalogDAO.create(catalog);
            }
        }
        List<Catalog> catalogs = DAO.getDAO().catalogDAO.getAll("");
        req.setAttribute(Msg.CATALOGS, catalogs);
        return Actions.CRUDCATALOGS.command;
    }
}