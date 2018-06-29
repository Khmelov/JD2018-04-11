package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
//import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
//import java.security.MessageDigest;




public class CmdSignUp extends Cmd {



    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            /*MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            final Base64 base64 = new Base64();
            md.update(password.getBytes());

            final byte[] enbytes = base64.encode(md.digest());*/

            if (login != null && email != null && password != null) {
                User user = new User(0,login,password.toString(),email,2);
                Dao.getDao().user.create(user);
                if(user.getId() > 0)
                    return  Action.LOGIN;
            }
        }
        return null;
    }
}
