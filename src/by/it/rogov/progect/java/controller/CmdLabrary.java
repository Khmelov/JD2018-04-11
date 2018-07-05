package by.it.rogov.progect.java.controller;


import by.it.rogov.progect.java.beans.Labrary;
import by.it.rogov.progect.java.beans.LabraryLittle;
import by.it.rogov.progect.java.beans.Permission;
import by.it.rogov.progect.java.beans.User;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

class CmdLabrary extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        int test=1;
        HttpSession session = req.getSession();

        Object oUser = session.getAttribute("user");
        Object oPermissin = session.getAttribute("permission");
        if (oUser == null)
            return Action.LOGIN;

        if (Util.isPost(req)) {
            if (req.getParameter("logout") != null) {
                session.invalidate();
                return Action.LOGIN;
            }
        }

        Permission permission =(Permission) oPermissin;
        if(req.getParameter("read")!=null&&permission!=null){
            String text = req.getParameter("read");
            String where = String.format(Locale.US, " WHERE ID='%s'", text);
            List<Labrary> labrarys = Dao.getDao().labrary.getAll(where);
            Labrary labrary=labrarys.get(0);
            session.setAttribute("labrary",labrary);
            test=1;
            session.setAttribute("test",test);
        }
        if (req.getParameter("back")!=null){
            test=0;
            session.setAttribute("test",test);


        }
        User user =(User) oUser;
        if(req.getParameter("permission")!=null){
            permission=new Permission(
                    0,
            1,
            user.getId()
                    );
            Dao.getDao().permission.create(permission);
            session.setAttribute("permission",permission);
        }


        String where = String.format(Locale.US, " WHERE users_id=%d", 1);
        List<LabraryLittle> textFrees = Dao.getDao().labrary.getTextFree(where);
        session.setAttribute("textFrees",textFrees);
        return null;
    }
}
