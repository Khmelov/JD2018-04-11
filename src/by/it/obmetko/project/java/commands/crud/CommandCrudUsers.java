package by.it.obmetko.project.java.commands.crud;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Role;
import by.it.obmetko.project.java.DAO.beens.User;
import by.it.obmetko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudUsers extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (FormUtil.isPost(req)) {

            int id = FormUtil.getInt(req.getParameter("id"));
            String login = FormUtil.getString(req.getParameter("login"), Pattern.LOGIN);
            String password = FormUtil.getString(req.getParameter("password"), Pattern.PASSWORD);
            String email = FormUtil.getString(req.getParameter("email"), Pattern.EMAIL);
            int roles_id = FormUtil.getInt(req.getParameter("roles_id"));
            User user = new User(id, login, password, email, roles_id);


            if (req.getParameter("Update") != null) {
                DAO.getDAO().userDAO.update(user);
            } else if (req.getParameter("Delete") != null) {
                DAO.getDAO().userDAO.delete(user);
            } else if (req.getParameter("Create") != null) {
                DAO.getDAO().userDAO.create(user);
            }

        }
        List<User> users = DAO.getDAO().userDAO.getAll("");
        req.setAttribute("users", users);
        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
        req.setAttribute("roles", roles);
        return null;

    }
}
