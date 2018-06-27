package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class CmdLogin extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (login != null && password != null ) {
                List<User> users = Dao.getDao().user.
                        getAll(String.format(Locale.US,
                                " WHERE login='%s' AND password='%s'", login, password));

                if(users.size() > 0){
                    User user = users.get(0);

                    req.setAttribute("user", user);
                }
            }
        }
        return null;
    }
}
