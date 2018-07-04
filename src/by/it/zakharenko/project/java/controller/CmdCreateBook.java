package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.beans.Book;
import by.it.zakharenko.project.java.beans.User;
import by.it.zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateBook extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        if (Util.isPost(req)) {
            String book = Util.getString(req, "text");
            if(book!=null) {
                return Action.LOGIN;
            }
        }
        return null;
    }
}
