package by.it.mokhart.project.java.controller;

import by.it.mokhart.project.java.beans.Ad;
import by.it.mokhart.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll("");
        req.setAttribute("ads", ads);
        return null;
    }
}
