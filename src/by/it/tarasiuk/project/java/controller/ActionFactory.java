package by.it.tarasiuk.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    Action defineAction(HttpServletRequest req) {
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty())
            return Action.valueOf(command.toUpperCase());
        else
            return Action.ERROR;
    }
}
