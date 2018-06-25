package by.it.kurmaz.project.java.controller;
import javax.servlet.http.HttpServletRequest;


class CmdIndex extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) {
        if (Util.isPost(req)) {
            String select = req.getParameter("select");
            if (select.equals("1"))
                return Actions.LOGIN;
            else if (select.equals("2"))
                return Actions.SIGNUP;
        }
        return null;
    }
}
