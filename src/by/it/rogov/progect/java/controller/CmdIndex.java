package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.LabraryLittle;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        String where = String.format(Locale.US, " WHERE users_id=%d", 1);
        List<LabraryLittle> textFrees = Dao.getDao().labrary.getTextFree(where);
        req.setAttribute("textFrees",textFrees);
        return null;
    }
}