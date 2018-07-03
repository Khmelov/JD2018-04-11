package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.User;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if(Util.isPost(req)){
            String login = Util.getString(req,"login");
            String password = Util.getString(req,"password");
            if(login!=null && password!=null){
                String where =String.format(Locale.US,"login='%s' AND password='%s' ",
                        login,password);
                List<User> users= Dao.getDao().user.getAll(where);
                if(users.size()>0){
                    User user =users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    return Action.LABRARY;
                }
            }
        }
        return null;
    }
}
