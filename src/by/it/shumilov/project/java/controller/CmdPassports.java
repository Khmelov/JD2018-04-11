package by.it.shumilov.project.java.controller;


import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.beans.Passport;
import by.it.shumilov.project.java.beans.User;
import by.it.shumilov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class CmdPassports extends Cmd{

//    static  void  getPasports(HttpServletResponse resp, Long id) throws IOException, SQLException {
//        String json = new Gson().toJson(Dao.getDao().passport.getAll( String.format(Locale.US,"where id='%d'", id)));
//        //resp.setContentType("application/json");
//        //resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(json);
//
//    }

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
            String phone = Util.getString(req,"phone");
            System.out.println(id + firstname+lastname+pasportid+phone);


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
//                if(avto.getId() > 0)
//
//                    req.setAttribute("avto", avto);
                //return  Action.CREATEAVTO;
            }
        }
        List<Passport> passports = dao.passport.getAll("");

        req.setAttribute("passports", passports);
        return null;
    }
}
