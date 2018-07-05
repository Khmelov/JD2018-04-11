package by.it.mokhart.project.java.controller;

import by.it.mokhart.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) {
        Dao.reset();
        return Actions.LOGIN;
    }
}