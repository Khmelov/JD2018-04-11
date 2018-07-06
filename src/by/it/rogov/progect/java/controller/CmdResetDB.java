package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao.reset();
        return Action.LOGIN;
    }
}
