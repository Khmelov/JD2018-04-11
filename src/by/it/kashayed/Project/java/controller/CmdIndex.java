package by.it.kashayed.Project.java.controller;

import by.it.kashayed.Project.java.bean.Cars;
import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Cars> cars = Dao.getDao().cars.getAll("");
        req.setAttribute("cars", cars);
        return null;
    }
}
