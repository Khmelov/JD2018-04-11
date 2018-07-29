package by.test.SCAND.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogOut extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return Actions.INDEX;
    }
}