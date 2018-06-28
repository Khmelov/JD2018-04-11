package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.BuyerDAO;
import by.it.obmetko.project.java.DAO.beens.Buyer;
import by.it.obmetko.project.java.controller.*;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandProfile extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {       HttpSession session = req.getSession();
        Buyer buyer = (Buyer) session.getAttribute(Msg.BUYER);
        if (buyer != null) {
                    req.setAttribute(Msg.PROFILE_LOGIN, buyer.getLogin());
                    req.setAttribute(Msg.PROFILE_PASSWORD, buyer.getPassword());

                            System.out.println(Arrays.toString(req.getCookies()));

                    if (FormUtil.isPost(req)) {
                            String login = FormUtil.getString(req.getParameter("email"), req.getParameter("newLogin"));
                            if (login != null) {
                                    buyer.setLogin(login);
                                    new BuyerDAO().update(buyer);
                                    req.setAttribute(Msg.PROFILE_LOGIN, buyer.getLogin());
                                    session.setAttribute(Msg.BUYER, buyer);
                                    return Action.PROFILE.command;
                                } else req.setAttribute(Msg.MESSAGE, "login==null");

                                    String password = FormUtil.getString(req.getParameter("email"), req.getParameter("newPassword"));
                            if (password != null) {
                                   buyer.setPassword(password);
                                    new BuyerDAO().update(buyer);
                                    req.setAttribute(Msg.PROFILE_PASSWORD, buyer.getPassword());
                                    session.setAttribute(Msg.BUYER, buyer);
                                    return Action.PROFILE.command;
                                } else req.setAttribute(Msg.MESSAGE, "password==null");
                       }
                    req.setAttribute(Msg.MESSAGE, getCookies(req));
                    return Action.PROFILE.command;
                } else return Action.LOGIN.command;
    }
    private String getCookies(HttpServletRequest req) {
                Cookie[] cookies = req.getCookies();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cookies.length; i++) {
                        if (cookies[i].getName().equals("loginCookie") || cookies[i].getName().equals("passwordCookie"))
                                sb.append("<br>").append("Encoded: ").append(cookies[i].getName()).append("=").append(cookies[i].getValue())
                                                .append("<br>").append("Decoded: ").append(cookies[i].getName()).append("=").append(decodeCookie(cookies[i].getValue())).append("<br>");
                   }
                return sb.toString();
           }

           String decodeCookie(String cookieValue) {

                return new String(Base64.decodeBase64(cookieValue.getBytes()));
        }
        }

