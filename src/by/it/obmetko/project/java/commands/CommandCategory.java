package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.BookDAO;
import by.it.obmetko.project.java.DAO.CategoryDAO;
import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Book;
import by.it.obmetko.project.java.DAO.beens.Buyer;
import by.it.obmetko.project.java.DAO.beens.Category;
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

public class CommandCategory extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {      if (req.getParameter("toBasket") != null) {
            Buyer buyer = (Buyer) req.getSession().getAttribute(Msg.BUYER);
            if (buyer != null) {
                int bookId = FormUtil.getInt(req.getParameter("bookToBasketId"));
                ListOfPurchases list = new ListOfPurchases(0, buyer.getId(), bookId);
                DAO.getDAO().listOfPurchasesDAO.create(list);
            } else {
                CommandError.errorMassage = "Вы не залогинелись";
                CommandError.errorDetails = "";
                return Action.ERROR.command;
            }
        }
        Category category = new CategoryDAO().read(FormUtil.getInt(req.getParameter("categoryId")));
        List<Book> books = new BookDAO().getAll("WHERE category_id=" + category.getId());
                req.setAttribute("booksSize", books.size());
                String strStart = req.getParameter("start");
                int start = 0;
                if (strStart != null) {
                        start = Integer.parseInt(strStart);

                            }
                books = new BookDAO().getAll(
                                String.format(" where category_id='%d' LIMIT %d, 10", category.getId(), start));

        req.setAttribute("category", category);
        req.setAttribute(Msg.BOOKS_IN_CATEGORY, books);
        return null;
    }
}