package by.it.sharin.jd03_04.java.controller;

import by.it.sharin.jd03_04.java.beans.Ad;
import by.it.sharin.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll("");
        req.setAttribute("ads", ads);
        return null;
    }
}
