package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.Labrary;
import by.it.rogov.progect.java.beans.User;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreateText extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object ObUser = session.getAttribute("user");
        if (ObUser == null) {
            return Action.LOGIN;
        }
        User user = (User) ObUser;
        if (user.getRoles_id() != 1) {
            return Action.LABRARY;

        } else {
            if (Util.isPost(req)) {
                String textFree = Util.getString(req, "textFree");
                String textPay = Util.getString(req, "textPay");
                Labrary labrary = new Labrary(
                        0,
                        textFree,
                        textPay,
                        1
                );
                Dao.getDao().labrary.create(labrary);
                return Action.LABRARY;
            }
        }
        return null;
    }
}
