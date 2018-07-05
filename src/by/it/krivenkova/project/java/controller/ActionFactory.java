package by.it.krivenkova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
   Actions defineAction(HttpServletRequest req) {
        String command = req.getParameter("command");
       System.out.println("command="+command);
        if (command != null && !command.isEmpty())
            return Actions.valueOf(command.toUpperCase());
        else
            return Actions.INDEX;
    }
}
