package by.it.sharin.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    Actions defineAction(HttpServletRequest req) {
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty())
            return Actions.valueOf(command.toUpperCase());
        else
            return Actions.ERROR;
    }
}
