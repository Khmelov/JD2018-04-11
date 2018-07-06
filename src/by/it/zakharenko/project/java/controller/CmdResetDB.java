package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        return Action.INDEX;
    }
}