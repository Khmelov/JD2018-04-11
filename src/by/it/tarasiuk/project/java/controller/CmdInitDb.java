package by.it.tarasiuk.project.java.controller;

import by.it.tarasiuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdInitDb extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.init();
        return Action.LOGIN;
    }
}
