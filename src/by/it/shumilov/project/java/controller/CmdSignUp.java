package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignUp extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equalsIgnoreCase("post")){
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User(0,login,password,email,2);
            Dao.getDao().user.create(user);
            if(user.getId() > 0)
                return  Action.LOGIN;
        }
        return null;
    }
}
