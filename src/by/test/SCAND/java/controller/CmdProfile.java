package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.Goods;
import by.test.SCAND.java.bean.User;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

public class CmdProfile extends Cmd {
    @Override
    Actions execute(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Object objectUser = session.getAttribute("user");
        if(objectUser==null) {
            return Actions.LOGIN;
        }
        User user = (User)objectUser;
        if (Util.isPost(request)){
            if(request.getParameter("update")!=null){
                String name = Util.getString(request,"name");
                String address = Util.getString(request,"address");
                String phone = Util.getString(request,"phone");
                user.setName(name);
                user.setAddress(address);
                user.setPhone(phone);
                Dao.getDao().user.update(user);
            }
            else if(request.getParameter("logout")!=null){
                session.invalidate();
                return Actions.INDEX;
            }else if(request.getParameter("delete")!=null){
                Dao.getDao().user.delete(user);
                session.invalidate();
                return Actions.INDEX;
            }else if(request.getParameter("del")!=null){
                return Actions.EDITAD;
            }
        }

        String where = String.format(Locale.US, " WHERE user_iduser=%d", user.getIduser());
        request.setAttribute("count",Dao.getDao().goods.getAll(where).size());

        int start = 0;
        String strStart = request.getParameter("start");
        if(strStart!=null){
            start = Integer.valueOf(strStart);
        }
        String limit = String.format("%s LIMIT %d, 5 ", where,start);
        List<Goods> goods = Dao.getDao().goods.getAll(limit);
        request.setAttribute("goods",goods);
        return null;
    }
}
