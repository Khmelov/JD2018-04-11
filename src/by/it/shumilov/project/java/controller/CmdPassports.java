package by.it.shumilov.project.java.controller;


import by.it.shumilov.project.java.beans.Passport;
import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;


public class CmdPassports extends Cmd{

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null)
            return Action.LOGIN;

        User user = (User) objUser;

        if(Util.isPost(req)){
            Long id = Util.getLong(req, "id");
            String firstname = Util.getString(req,"firstname");
            String lastname = Util.getString(req,"lastname");
            String pasportid = Util.getString(req,"pasportid");
            String phone = Util.getNumber(req,"phone");


            if (firstname != null && lastname != null && pasportid != null && phone != null ) {
                Passport passport = new Passport((id==null)?0:id,firstname,lastname,pasportid,phone,user.getId());
                System.out.println(passport);
                if (req.getParameter("Update") != null) {
                    dao.passport.update(passport);
                } else if (req.getParameter("Delete") != null) {
                    dao.passport.delete(passport);
                } else  if (req.getParameter("Add") != null) {
                    dao.passport.create(passport);
                }
;
            }
        }

        List<Passport> passports = dao.passport.getAll(String.format(Locale.US, "where users_id='%d'", user.getId()));

        req.setAttribute("passports", passports);
        return null;
    }
}
