package by.it.shumilov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogOut extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {

        HttpSession session = req.getSession();
        session.invalidate();

        return Action.LOGIN;
    }
}