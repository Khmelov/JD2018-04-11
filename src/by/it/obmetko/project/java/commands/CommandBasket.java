package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.ListOfPurchasesDAO;
import by.it.obmetko.project.java.DAO.beens.Book;
import by.it.obmetko.project.java.DAO.beens.ListOfPurchases;
import by.it.obmetko.project.java.DAO.beens.User;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.Actions;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandBasket extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        User user;
                 if ((user = (User) req.getSession().getAttribute(Msg.USER)) != null) {
                            String strStart = req.getParameter("start");
                            int start = 0;
                            if (strStart != null) {
                                    start = Integer.parseInt(strStart);

                                        }
                List<ListOfPurchases> purchasesList =
                        new ListOfPurchasesDAO().getAll("WHERE Users_id=" + user.getId());
                List<Book> booksInBasket = new ArrayList<>(purchasesList.size());
                            for (int i = start; i < purchasesList.size() && i < start + 5; i++) {
                        booksInBasket.add(DAO.getDAO().bookDAO.read(purchasesList.get(i).getBooks_id()));
                    }
                    req.setAttribute(Msg.PURCHASES, booksInBasket);
                                req.setAttribute("size", purchasesList.size());
                    return Actions.BASKET.command;
                } else {
                    CommandError.errorMassage = "Вы не залогинились";
                    CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
                    return Actions.ERROR.command;
                }
            }
        }