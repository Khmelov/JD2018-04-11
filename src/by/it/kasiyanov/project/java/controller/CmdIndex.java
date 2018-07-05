package by.it.kasiyanov.project.java.controller;

import by.it.kasiyanov.project.java.beans.TravelOffers;
import by.it.kasiyanov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<TravelOffers> travelOffers = Dao.getDao().travelOffers.getAll("");
        req.setAttribute("travelOffers", travelOffers);
        return null;
    }
}
