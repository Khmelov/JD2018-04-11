package by.it.tarasiuk.project.java.controller;

import by.it.tarasiuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDb extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        return Action.LOGIN;
    }
}
