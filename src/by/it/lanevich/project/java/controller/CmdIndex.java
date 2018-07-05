package by.it.lanevich.project.java.controller;


import by.it.lanevich.project.java.beans.Order;
import by.it.lanevich.project.java.dao.Dao;
import by.it.lanevich.project.java.beans.Good;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Good> goods = Dao.getDao().good.getAll("");
        req.setAttribute("goods", goods);
        return null;
    }
}
