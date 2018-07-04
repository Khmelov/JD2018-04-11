package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends  Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {

        List<Avto> all = Dao.getDao().avto.getAll("");
        req.setAttribute("avtos",all);
        return null;
    }
}
