package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.controller.*;
import by.it.obmetko.project.java.BD.DropAllTables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandResetDB extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
       if (!FormUtil.isPost(req)) {
            DropAllTables.main(null);
            req.setAttribute(Msg.MESSAGE, "База данных удалена!!!");
        }
            return Action.RESETDB.command;
        }

}