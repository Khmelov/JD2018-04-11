package by.it.obmetko.project.java.commands.crud;

import by.it.obmetko.project.java.DAO.DAO;
import by.it.obmetko.project.java.DAO.beens.Role;
import by.it.obmetko.project.java.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudRoles extends ActionCommand {

            @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
                if (FormUtil.isPost(req)) {

                    int id = FormUtil.getInt(req.getParameter("id"));
                    String role1=FormUtil.getString(req.getParameter("role"),Pattern.ROLE);
                    Role role =new Role(id,role1);

                    if (req.getParameter("Update") != null) {
                        DAO.getDAO().roleDAO.update(role);
                    } else if (req.getParameter("Delete") != null) {
                        DAO.getDAO().roleDAO.delete(role);
                    } else if (req.getParameter("Create") != null) {
                        DAO.getDAO().roleDAO.create(role);
                    }

                    }
                List<Role> roles = DAO.getDAO().roleDAO.getAll("");
                req.setAttribute(Msg.ROLES, roles);
                return Actions.CRUDROLES.command;
            }
}