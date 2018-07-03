package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.User;
import by.it.obmetko.project.java.controller.*;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CommandLogIn extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
            if (FormUtil.isPost(req)) {
                String login = FormUtil.getString(req, "login");
                String password = FormUtil.getString(req, "password");
                if (login != null && password != null) {
                    String where = String.format(Locale.US,
                            " WHERE login='%s' AND password='%s' ",
                            login, password);
                    List<User> users = DAO.getDao().userDAO.getAll(where);
                    if (users.size() > 0) {
                        User user = users.get(0);
                        HttpSession session = req.getSession();
                        session.setAttribute("user", user);
                        setCookies(resp, user);
                        setCookies(resp, user);
                        return Actions.PROFILE.command;
                    }
                }
            }
            return null;

        }


    void setCookies(HttpServletResponse resp, User user) {
        List<Cookie> cookies = new ArrayList<>(2);
        cookies.add(new Cookie("loginCookie", encodeCookie(user.getLogin())));
        cookies.add(new Cookie("passwordCookie", encodeCookie(user.getPassword())));
        cookies.get(0).setMaxAge(60);
        cookies.get(1).setMaxAge(60);
        resp.addCookie(cookies.get(0));
        resp.addCookie(cookies.get(1));
    }

    String encodeCookie(String cookieValue){
        //в файле deploy.xml нужно обязательно прописать
        // <fileset dir="${local.lib.dir}" includes="commons-codec-1.10.jar"/>
        return new String(Base64.encodeBase64(cookieValue.getBytes()));
    }
}