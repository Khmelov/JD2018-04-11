package by.it.kashayed.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    Actions defiAction(HttpServletRequest request) {
        String command = request.getParameter("command");
        if (command == null && !command.isEmpty()) {
            return Actions.valueOf(command.toUpperCase());
        } else
            return Actions.ERROR;
    }
}
