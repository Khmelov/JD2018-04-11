package by.it.shekh.project.java.controller;


import by.it.shekh.project.java.beans.FacadeGeneral;
import by.it.shekh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        req.setAttribute("count", Dao.getDao().facadeGeneral.getAll("").size());
        int start = 0;
        String strStart = req.getParameter("start");
        if (strStart != null) {
            start = Integer.valueOf(strStart);
        }
        String limit = String.format(" LIMIT %d,5", start);
        List<FacadeGeneral> facades = Dao.getDao().facadeGeneral.getAll(limit);
        req.setAttribute("facades", facades);
        return null;
    }
}
