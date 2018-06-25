package by.it.kurmaz.project.java.controller;
import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws Exception{
        if (Util.isPost(req)) {
            String login = req.getParameter("login");
            String email = req.getParameter("E-mail");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            if (login != null && email != null && password != null && phone !=null) {
                User user = new User(0, login, password, email, phone, "regular", 2);
                DAO.getDao().user.create(user);
                if (user.getId() > 0)
                    return Actions.LOGIN;
            }
        }
        return null;
    }
}
