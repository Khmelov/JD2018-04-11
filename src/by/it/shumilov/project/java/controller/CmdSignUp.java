package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
//import java.security.MessageDigest;




public class CmdSignUp extends Cmd {



    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String login = Util.getString(req,"login");
            String email = Util.getEmail(req,"email");
            String password = Util.getString(req,"password");

            /*MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            final Base64 base64 = new Base64();
            md.update(password.getBytes());

            final byte[] enbytes = base64.encode(md.digest());*/

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
