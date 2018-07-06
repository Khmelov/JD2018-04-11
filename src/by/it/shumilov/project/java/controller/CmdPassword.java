package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CmdPassword extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;
        User user = (User)objUser;
        if(Util.isPost(req)){
            String password = Util.getString(req,"password");
            String password1 = Util.getString(req,"password1");
            String password2 = Util.getString(req,"password2");
            String old = DigestUtils.sha256Hex(password);

            if(!old.equals(user.getPassword())) {

                req.setAttribute("help_password", "Old password incorrect");
                return null;
            }
            if(!password1.equals(password2)){
                req.setAttribute("help_password1", "Пароли не совпадают");
                return null;
            }
            if(password.equals(password2)){
                req.setAttribute("help_password1", "Новый пароль совпадает со старым");
                return null;

            }

            if (password1 != null ) {
                user.setPassword( DigestUtils.sha256Hex(password1));
                Dao.getDao().user.update(user);
                req.setAttribute("newpass", "Пароль изменен!");


            }
        }
        return null;
    }
}
