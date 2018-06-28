package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.controller.Action;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.LogInBuyer;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandLogOut extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {   LogInBuyer.resetInstance();
        HttpSession session = req.getSession();
               session.invalidate();
       // req.setAttribute(Msg.PROFILE_LOGIN,LogInBuyer.currentBuyer!=null?LogInBuyer.currentBuyer.getLogin():"");
        req.setAttribute(Msg.BUYER, "вы вышли из профиля");
        return Action.LOGIN.command;
    }
}