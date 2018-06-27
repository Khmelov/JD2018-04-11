package by.it.gavrilchik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    Actions defineAction(HttpServletRequest req){
        String command = req.getParameter("command");
        if (command!=null && !command.isEmpty()){
            Actions actions=Actions.valueOf(command.toUpperCase()); //perepisat with else
        }
        return Actions.ERROR;
    }
}
