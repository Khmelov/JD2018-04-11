package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.beans.Book;
import by.it.zakharenko.project.java.beans.User;
import by.it.zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdCreateBook extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            String description = Util.getString(req, "description");
            String name = Util.getString(req, "name");
            String author = Util.getString(req, "author");
            String genre = Util.getString(req, "genre");
            int pages = Util.getInteger(req, "pages");
            double price = Util.getDouble(req, "price");
            Book book = new Book(0,
                    description,
                    name, author,
                    genre, pages,
                    price,
                    user.getId());
            Dao.getDao().book.create(book);
            return Action.PROFILE;
        }
        return null;
    }
}