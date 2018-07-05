package by.it.tarasiuk.project.java.controller;

import by.it.tarasiuk.project.java.beans.Advert;
import by.it.tarasiuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Advert> adverts = Dao.getDao().advert.getAll("");
        req.setAttribute("adverts",adverts);
        return null;
    }
}
