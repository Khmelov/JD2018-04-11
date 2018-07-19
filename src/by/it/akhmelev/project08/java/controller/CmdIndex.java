package by.it.akhmelev.project08.java.controller;


import by.it.akhmelev.project08.java.beans.Ad;
import by.it.akhmelev.project08.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        req.setAttribute("count",Dao.getDao().ad.getAll("").size());

        int start=0;
        String strStart=req.getParameter("start");
        if (strStart!=null)
            start=Integer.valueOf(strStart);
        String limit=String.format(" LIMIT %d, 10",start);
        List<Ad> ads = Dao.getDao().ad.getAll(limit);
        req.setAttribute("ads", ads);
        return null;
    }
}
