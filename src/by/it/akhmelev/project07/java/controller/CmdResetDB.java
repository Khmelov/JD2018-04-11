package by.it.akhmelev.project07.java.controller;


import by.it.akhmelev.project07.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        return Action.LOGIN;
    }
}
