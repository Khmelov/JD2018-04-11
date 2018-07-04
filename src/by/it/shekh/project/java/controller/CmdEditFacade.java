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
            Long id = Util.getLong(req, "id_facade");
            String name = Util.getString(req, "facade_name");
            String description = Util.getString(req, "facade_description");
            String dimensions = Util.getString(req, "facade_dimensions");
            Double price = Util.getDouble(req, "facade_price");
            String specs = Util.getString(req, "facade_specs");
            FacadeGeneral facade =
                    new FacadeGeneral(id, name, dimensions, description, price, specs);
            if (req.getParameter("Update") != null) {
                dao.facadeGeneral.update(facade);
            } else if (req.getParameter("Delete") != null) {
                dao.facadeGeneral.delete(facade);
            }
        }
        List<FacadeGeneral> facades = dao.facadeGeneral.getAll("");
        req.setAttribute("facades", facades);
        return null;

    }
}
