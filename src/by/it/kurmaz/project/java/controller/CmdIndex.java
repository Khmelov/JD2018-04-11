package by.it.kurmaz.project.java.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class CmdIndex extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        if (Util.isPost(req)) {
            if (req.getParameter("select") != null) {
                String select = Util.getString(req, "select");
                if (select.equals("user"))
                    return new ActionResult(Actions.LOGIN);
                else if (select.equals("admin"))
                    return new ActionResult(Actions.ADMLOGIN);
            }
        }
        return null;
    }
}
