package by.it.krivenkova.project.java.controller;

import by.it.krivenkova.project.java.beans.Route;
import by.it.krivenkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        List<Route> routes = Dao.getDao().route.getAll("");
        req.setAttribute("routes", routes);
        return null;
    }
}
