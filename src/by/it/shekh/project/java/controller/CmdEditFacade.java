package by.it.shekh.project.java.controller;

import by.it.shekh.project.java.beans.FacadeGeneral;
import by.it.shekh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditFacade extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            Long id = Util.getLong(req, "id");
            String name = Util.getString(req, "name");
            String description = Util.getString(req, "description");
            String dimensions = Util.getString(req, "dimensions");
            Double price = Util.getDouble(req, "price");
            String specs = Util.getString(req, "facade_specs");
            FacadeGeneral facade =
                    new FacadeGeneral(id, name, dimensions, description, price, specs);
            if (req.getParameter("Update") != null) {
                dao.facadeGeneral.update(facade);
            } else if (req.getParameter("Delete") != null) {
                dao.facadeGeneral.delete(facade);
            }
        }
        req.setAttribute("count", Dao.getDao().facadeGeneral.getAll("").size());
        int start = 0;
        String strStart = req.getParameter("start");
        if (strStart != null) {
            start = Integer.valueOf(strStart);
        }
        String limit = String.format(" LIMIT %d, 5", start);
        List<FacadeGeneral> facades = dao.facadeGeneral.getAll(limit);
        req.setAttribute("facades", facades);
        return null;

    }
}
