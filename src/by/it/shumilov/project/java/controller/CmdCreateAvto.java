package by.it.shumilov.project.java.controller;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateAvto extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String mark = req.getParameter("mark");
            String model = req.getParameter("model");
            String color = req.getParameter("color");
            String nvin = req.getParameter("nvin");
            String year = req.getParameter("year");
            String ngos = req.getParameter("ngos");
            String rate = req.getParameter("rate");


            if (mark != null && model != null && color != null && nvin != null && year != null && ngos != null && rate != null) {
                Avto avto = new Avto(0,mark,model,color,nvin,Integer.valueOf(year),ngos,Double.valueOf(rate),null);

                Dao.getDao().avto.create(avto);
                if(avto.getId() > 0)

                    req.setAttribute("avto", avto);
                    //return  Action.CREATEAVTO;
            }
        }
        return null;
    }
}
