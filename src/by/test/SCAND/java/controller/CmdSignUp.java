package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.User;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignUp extends Cmd {
    @Override
    Actions execute(HttpServletRequest req) throws Exception {
        if(Util.isPost(req)){
            String name = Util.getString(req,"name");
            String address = Util.getString(req,"address");
            String phone = Util.getString(req,"phone");
            if(name!=null && address!=null && phone!=null){
                User user = new User(0,name,address,phone,2);
                Dao.getDao().user.create(user);
                if(user.getIduser()>0){
                    return Actions.LOGIN;
                }
            }
        }
        return null;
    }
}
