package by.it.krivenkova.project.java.controller;

import by.it.krivenkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) {
        Dao.reset();
        return Actions.LOGIN;
    }
}
