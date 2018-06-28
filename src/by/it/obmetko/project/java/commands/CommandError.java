package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.controller.Action;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;


public class CommandError extends ActionCommand {
    public static String errorMassage;
    public static String errorDetails;

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {      req.setAttribute(Msg.ERROR, errorMassage);
                req.setAttribute(Msg.ERROR_DETAILS, errorDetails);
                return Action.ERROR.command;
            }
}
