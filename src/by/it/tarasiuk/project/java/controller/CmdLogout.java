package by.it.tarasiuk.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return Action.INDEX;
    }
}
