package by.it.kurmaz.project.java.controller;
import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

class CmdSignUp extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        if (Util.isPost(req)) {
            String login = Util.getString(req,"login");
            String email = Util.getEmail(req,"E-mail");
            String password = Util.getString(req,"password");
            String phone = Util.getString(req, "phone");
            if (login != null && email != null && password != null && phone !=null) {
                User user = new User(0, login, password, email, phone, "regular", 2);
                DAO.getDao().user.create(user);
                if (user.getId() > 0) {
                    resp.addCookie(new Cookie("user_id", "" + user.getId()));
                    return new ActionResult(Actions.ADDRESS);
                }
            }
        }
        return null;
    }
}
