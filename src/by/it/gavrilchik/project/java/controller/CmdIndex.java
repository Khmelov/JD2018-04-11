package by.it.gavrilchik.project.java.controller;

import by.it.gavrilchik.project.java.DAO.Dao;
import by.it.gavrilchik.project.java.beans.Ad;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll("");
        req.setAttribute("ads", ads);
        return null;
    }
}
