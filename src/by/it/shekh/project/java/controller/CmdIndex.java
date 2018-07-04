package by.it.shekh.project.java.controller;


import by.it.shekh.project.java.beans.FacadeGeneral;
import by.it.shekh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<FacadeGeneral> facades = Dao.getDao().facadeGeneral.getAll("");
        req.setAttribute("facades", facades);
        return null;
    }
}
