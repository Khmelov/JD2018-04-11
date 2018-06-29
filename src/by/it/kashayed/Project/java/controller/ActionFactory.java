package by.it.kashayed.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    Action defineAction(HttpServletRequest request) {
        String command = request.getParameter("command");
        System.out.println("command="+command);
        if (command != null && !command.isEmpty()) {
            return Action.valueOf(command.toUpperCase());
        } else
            return Action.ERROR;
    }
}
