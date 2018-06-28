package by.it.obmetko.project.java.commands.crud;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.ListOfPurchases;
import by.it.obmetko.project.java.controller.Action;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.FormUtil;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

        public class CommandCrudListOfPurchases extends ActionCommand {

            @Override
            public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
                if (FormUtil.isPost(req)) {
                    ListOfPurchases listOfPurchases = new ListOfPurchases(FormUtil.getInt(req.getParameter("id")),
                            FormUtil.getInt(req.getParameter("buyers_id")),
                            FormUtil.getInt(req.getParameter("books_id")));
                    if (req.getParameter("Update") != null) {
                        DAO.getDAO().listOfPurchasesDAO.update(listOfPurchases);
                    } else if (req.getParameter("Delete") != null) {
                        DAO.getDAO().listOfPurchasesDAO.delete(listOfPurchases);
                    } else if (req.getParameter("Create") != null) {
                        DAO.getDAO().listOfPurchasesDAO.create(listOfPurchases);
                    }
                }
                List<ListOfPurchases> listOfPurchases = DAO.getDAO().listOfPurchasesDAO.getAll("");
                req.setAttribute(Msg.LIST_OF_PURCHASES, listOfPurchases);
                return Action.CRUDLISTOFPURCHASES.command;
            }
        }