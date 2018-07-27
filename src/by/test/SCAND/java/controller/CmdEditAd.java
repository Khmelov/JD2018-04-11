package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.Goods;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdEditAd extends Cmd {
    @Override
    Actions execute(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Object objectUser = session.getAttribute("user");
        if(objectUser==null) {
            session.invalidate();
            return Actions.INDEX;
        }
        Dao dao = Dao.getDao();
        if (Util.isPost(request)) {
            int id = Util.getInteger(request,"idgoods");
            String name = Util.getString(request, "name");
            String description = Util.getString(request, "description");
            //Object photo = Util.getObject(req, "photo");
            Double price = Util.getDouble(request, "price");
//            Integer user_iduser = Util.getInteger(request,"user_iduser");
            if(price==null){
                price=0.1;
            }
            Goods goods = new Goods(id,name,description, price,"1",1);
            if(request.getParameter("Update")!=null){
                dao.goods.update(goods);
            }
            if(request.getParameter("Delete")!=null){
                dao.goods.delete(goods);
            }
        }
        List<Goods> goodsAll= dao.goods.getAll("");
        request.setAttribute("goods",goodsAll);
        return null;
    }
}
