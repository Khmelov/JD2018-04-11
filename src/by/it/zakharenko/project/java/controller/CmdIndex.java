package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.beans.Book;
import by.it.zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Book> books = Dao.getDao().book.getAll("");
        req.setAttribute("books", books);
        return null;
    }
}