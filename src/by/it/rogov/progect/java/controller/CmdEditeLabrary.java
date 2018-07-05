package by.it.rogov.progect.java.controller;

import by.it.rogov.progect.java.beans.Labrary;
import by.it.rogov.progect.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

public class CmdEditeLabrary extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Dao dao = Dao.getDao();
        Labrary labrary;
        int edit;
        if (req.getParameter("read") != null) {
            String text = req.getParameter("read");
            String where = String.format(Locale.US, " WHERE ID='%s'", text);
            List<Labrary> labrarys = Dao.getDao().labrary.getAll(where);
             labrary= labrarys.get(0);
            session.setAttribute("labrary", labrary);
            edit = 1;
            session.setAttribute("edit", edit);
        }
        if (req.getParameter("back") != null) {
            edit = 0;
            session.setAttribute("edit", edit);
        }


        if (req.getParameter("update") != null) {
            labrary=(Labrary) session.getAttribute("labrary");
            labrary.setTextFree(Util.getString(req, "textFree"));
            labrary.setTextPay(Util.getString(req, "textPay"));
            dao.labrary.update(labrary);
        } else if (req.getParameter("delete") != null) {
            labrary=(Labrary) session.getAttribute("labrary");
            labrary.setTextFree(Util.getString(req, "textFree"));
            labrary.setTextPay(Util.getString(req, "textPay"));
            dao.labrary.update(labrary);
            dao.labrary.delete(labrary);
            edit=0;
            session.setAttribute("edit",edit);
            return Action.LABRARY;
        }


        return null;
    }
}
