package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdReset extends Cmd{
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        DAO.reset();
        return new ActionResult(Actions.INDEX);
    }
}
