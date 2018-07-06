package by.it.gavrilchik.project.java.controller;

import by.it.gavrilchik.project.java.DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        return Action.LOGIN;
    }
}
