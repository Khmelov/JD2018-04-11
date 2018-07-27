package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.User;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdLogin extends Cmd {
    @Override
    Actions execute(HttpServletRequest request) throws SQLException {
        if (Util.isPost(request)) {
            String name = Util.getString(request, "name");
            String phone = Util.getString(request, "phone");
            if (name != null && phone != null) {
//                if (name.equalsIgnoreCase("admin")&&phone.equalsIgnoreCase("admin")) {
                    String where = String.format(Locale.US,
                            " WHERE name='%s' AND phone='%s' ",
                            name, phone);
                    List<User> users = Dao.getDao().user.getAll(where);
                    if (users.size() > 0) {
                        User user = users.get(0);
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        return Actions.PROFILE;
                    }
                } else return Actions.SIGNUP;
//            }
        }
        return null;
    }
}
