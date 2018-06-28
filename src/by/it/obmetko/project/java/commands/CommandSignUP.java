package by.it.obmetko.project.java.commands;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Buyer;
import by.it.obmetko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandSignUP extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        if (req.getSession().getAttribute(Msg.BUYER) != null) {
            CommandError.errorMassage="Вы уже вошли на сайт";
            CommandError.errorDetails="<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Action.ERROR.command;
        }
        if (!FormUtil.isPost(req))
            return Action.SIGNUP.command;
        String login =FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
        String email = FormUtil.getString(req.getParameter("Email"),Pattern.EMAIL);
        String password =FormUtil.getString(req.getParameter("Password"),Pattern.PASSWORD);
                Buyer buyer = new Buyer(0, login, password, email, 1);
        DAO dao = DAO.getDAO();
        dao.buyerDAO.create(buyer);
        if (buyer.getId() > 0){
            return Action.LOGIN.command;
        }
        else {
            CommandError.errorMassage="Ошибка добавления пользователя";
            CommandError.errorDetails="<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Action.ERROR.command;
        }
    }
}