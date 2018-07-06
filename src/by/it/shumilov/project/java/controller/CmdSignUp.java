package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.http.HttpServletRequest;





public class CmdSignUp extends Cmd {



    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String login = Util.getString(req,"login");
            String email = Util.getEmail(req,"email");
            String password = Util.getString(req,"password");


            if (login != null && email != null && password != null) {
                User user = new User(0,login,DigestUtils.sha256Hex(password),email,2);
                Dao.getDao().user.create(user);
                if(user.getId() > 0)
                    return  Action.LOGIN;
            }
        }
        return null;
    }
}
