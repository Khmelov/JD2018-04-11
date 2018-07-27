package by.test.SCAND.java.controller;

import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdResetDB extends Cmd {
    @Override
    Actions execute(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        Dao.reset();
        return Actions.INDEX;
    }
}
