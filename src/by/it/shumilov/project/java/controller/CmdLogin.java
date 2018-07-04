package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
//import org.apache.commons.codec.binary.Base64;
//import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;


public class CmdLogin extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            /*MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            Base64 base64 = new Base64();
            md.update(password.getBytes());
            byte[] enbytes = base64.encode(md.digest());*/


            if (login != null && password != null ) {
                List<User> users = Dao.getDao().user.
                        getAll(String.format(Locale.US,
                                " WHERE login='%s' AND password='%s'", login, password.toString()));

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
