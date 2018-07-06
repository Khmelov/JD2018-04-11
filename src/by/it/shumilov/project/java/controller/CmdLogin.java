package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.util.List;
import java.util.Locale;


public class CmdLogin extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String login = Util.getString(req,"login");
            String password = Util.getString(req,"password");

            if (login != null && password != null ) {
                List<User> users = Dao.getDao().user.
                        getAll(String.format(Locale.US,
                                " WHERE login='%s' AND password='%s'", login, DigestUtils.sha256Hex(password)));

                if(users.size() > 0){
                    User user = users.get(0);
                    HttpSession session = req.getSession();

                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(30);
                    return Action.PROFILE;
                }
            }
        }
        return null;
    }
}
