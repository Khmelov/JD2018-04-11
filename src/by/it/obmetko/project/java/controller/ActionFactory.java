package by.it.obmetko.project.java.controller;

import javax.servlet.http.HttpServletRequest;


public class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest req){
        ActionCommand command;
        String action=req.getParameter("command");
        try {
            Action currentEnum = Action.valueOf(action.toUpperCase());
            command=currentEnum.command;
        }catch (IllegalArgumentException e){
            command=Action.ERROR.command;
        }
        return command;
    }
        }