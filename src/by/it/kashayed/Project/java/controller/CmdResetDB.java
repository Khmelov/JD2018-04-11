package by.it.kashayed.Project.java.controller;


import by.it.kashayed.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        return Action.LOGIN;
    }
}
