package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.Goods;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        req.setAttribute("count",Dao.getDao().goods.getAll("").size());
        int start=0;
        String strStart=req.getParameter("start");
        if (strStart!=null) {
            start = Integer.valueOf(strStart);
        }
        String limit=String.format(" LIMIT %d, 5",start);
        List<Goods> goods = Dao.getDao().goods.getAll(limit);
        req.setAttribute("goods", goods);
        return null;
    }
}
