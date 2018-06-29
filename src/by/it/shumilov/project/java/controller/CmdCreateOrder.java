package by.it.shumilov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateOrder extends  Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)) {
            String startorder = req.getParameter("startorder");
            System.out.println(startorder);
        }
        return null;
    }
}
