package by.test.SCAND.java.controller;


import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    Actions defineAction(HttpServletRequest req) {
        String command = req.getParameter("command");
        System.out.println("command="+command);
        if (command != null && !command.isEmpty())
            return Actions.valueOf(command.toUpperCase());
        else
            return Actions.INDEX;
    }
}
