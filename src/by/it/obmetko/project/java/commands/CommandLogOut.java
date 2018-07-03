package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.controller.Actions;
import by.it.obmetko.project.java.controller.ActionCommand;
import by.it.obmetko.project.java.controller.LogInUser;
import by.it.obmetko.project.java.controller.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandLogOut extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {LogInUser.resetInstance();
        HttpSession session = req.getSession();
               session.invalidate();
       // req.setAttribute(Msg.PROFILE_LOGIN,LogInUser.currentUser!=null?LogInUser.currentUser.getLogin():"");
        req.setAttribute(Msg.USER, "вы вышли из профиля");
        return Actions.LOGIN.command;
    }
}