package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.User;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    Actions execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Object objectUser = session.getAttribute("user");
        if(objectUser==null) {
            session.invalidate();
            return Actions.INDEX;
        }
        Dao dao = Dao.getDao();
        if(Util.isPost(request)){
            int id = Util.getInteger(request,"iduser");
            String name = Util.getString(request,"name");
            String address = Util.getString(request,"address");
            String phone = Util.getString(request,"phone");
            Integer clientId = Util.getInteger(request,"clients_idclients");
            if(clientId==null){
                clientId=2;
            }
            User user = new User(id,name,address,phone,clientId);
            if(request.getParameter("Update")!=null){
                dao.user.update(user);
            }
            else if(request.getParameter("Delete")!=null){
                dao.user.delete(user);
            }
        }
        List<User> users= dao.user.getAll("");
        request.setAttribute("user",users);
        return null;
    }
}
