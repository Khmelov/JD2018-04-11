package by.it.obmetko.project.java.commands.crud;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Buyer;
import by.it.obmetko.project.java.DAO.beens.Role;
import by.it.obmetko.project.java.commands.CommandError;
import by.it.obmetko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandCrudBuyer extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {       if (FormUtil.isPost(req)) {
            int id = FormUtil.getInt(req.getParameter("id"));
            String login = FormUtil.getString(req.getParameter("login"), Pattern.LOGIN);
            String password = FormUtil.getString(req.getParameter("password"), Pattern.PASSWORD);
            String email = FormUtil.getString(req.getParameter("email"), Pattern.EMAIL);
            int roles_id = FormUtil.getInt(req.getParameter("roles_id"));
            Buyer buyer = new Buyer(id, login, password, email, roles_id);

            if (req.getParameter("Update") != null) {
                DAO.getDAO().buyerDAO.update(buyer);
            } else if (req.getParameter("Delete") != null) {
                if (((Buyer) req.getSession().getAttribute(Msg.Buyer)).getRoles_id() != roles_id) {
                    DAO.getDAO().buyerDAO.delete(buyer);
                } else {
                    CommandError.errorMassage = "Вы не можете удалить себя";
                    CommandError.errorDetails = "";
                    return Action.ERROR.command;
                }
            } else if (req.getParameter("Create") != null) {
                DAO.getDAO().buyerDAO.create(buyer);
            }
        }
        List<Buyer> buyers = DAO.getDAO().buyerDAO.getAll("");
        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
        req.setAttribute(Msg.Buyer, buyers);
        req.setAttribute(Msg.ROLES, roles);
        return Action.CRUDBuyerS.command;
    }
}