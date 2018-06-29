package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.Address;
import by.it.kurmaz.project.java.beans.User;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.BCodec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdLogin extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req , HttpServletResponse resp) throws SQLException, EncoderException {
        if (Util.isPost(req)) {
            String login = Util.getString(req,"login");
            String password = Util.getString(req,"password");
            if (login != null && password != null) {
                String where = String.format(Locale.US,
                        " WHERE login='%s' AND password='%s' ",
                        login, password);
                List<User> users = DAO.getDao().user.getAll(where);
                if (users.size() > 0) {
                    User user = users.get(0);
                    int user_id = (int)user.getId();
                    where = String.format(Locale.US, "WHERE users_ID='%d'", user_id);
                    List<Address> addresses = DAO.getDao().address.getAll(where);
                    Address address = addresses.get(0);
                    HttpSession session = req.getSession();
                    BCodec codec = new BCodec();
                    String encode = codec.encode(user.getPassword());
                    user.setPassword(encode);
                    session.setAttribute("address", address);
                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(30);
                    Cookie sessionID = new Cookie("sessionId", session.getId());
                    resp.addCookie(sessionID);
                    Cookie passwordCookie = new Cookie("password", encode);
                    Cookie loginCookie = new Cookie("login", user.getLogin());
                    passwordCookie.setMaxAge(60); loginCookie.setMaxAge(60);
                    resp.addCookie(loginCookie); resp.addCookie(passwordCookie);
                    return new ActionResult(Actions.PROFILE);
                }
            }
        }
        return null;
    }
}
