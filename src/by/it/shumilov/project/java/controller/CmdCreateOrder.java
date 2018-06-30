package by.it.shumilov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdCreateOrder extends  Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;
        if(Util.isPost(req)) {
            String startorder = req.getParameter("startorder");
            System.out.println(startorder);
        }
        return null;
    }
}
