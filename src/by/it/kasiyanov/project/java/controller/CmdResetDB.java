package by.it.kasiyanov.project.java.controller;

import by.it.kasiyanov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao.reset();
        return Action.LOGIN;
    }
}
