package by.it.lanevich.project.java.controller;


import by.it.lanevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        return Action.LOGIN;
    }
}
