package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetBD extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao.reset();
        return Action.LOGIN;
    }
}
