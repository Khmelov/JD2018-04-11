package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;

import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdCreateAvto extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;
        else if(((User) objUser).getRoles_id() != 1)
            return Action.INDEX;

        if(Util.isPost(req)){
            Long id = Util.getLong(req, "id");
            String mark = Util.getString(req,"mark");
            String model = Util.getString(req,"model");
            String color = Util.getString(req,"color");
            String nvin = Util.getVin(req,"nvin");
            Integer year = Util.getYear(req,"year");
            String ngos = Util.getGos(req,"ngos");
            Double rate = Util.getDouble(req,"rate");


            if (mark != null && model != null && color != null && nvin != null && year != null && ngos != null && rate != null) {
                Avto avto = new Avto((id==null)?0:id,mark,model,color,nvin,year,ngos,rate,null);

                if (req.getParameter("Update") != null) {
                    dao.avto.update(avto);
                } else if (req.getParameter("Delete") != null) {
                    dao.avto.delete(avto);
                } else  if (req.getParameter("Add") != null) {
                    dao.avto.create(avto);
                }

            }
        }
        List<Avto> avtos = dao.avto.getAll("");
        req.setAttribute("avtos", avtos);
        return null;
    }
}
