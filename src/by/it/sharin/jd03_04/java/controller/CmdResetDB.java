package by.it.sharin.jd03_04.java.controller;


import by.it.sharin.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends by.it.sharin.jd03_04.java.controller.Cmd {
    @Override
    by.it.sharin.jd03_04.java.controller.Action execute(HttpServletRequest req) {
        Dao.reset();
        return by.it.sharin.jd03_04.java.controller.Action.LOGIN;
    }
}
