package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdCreatePublication extends Cmd {

    @Override
    Action execute(HttpServletRequest req) {
        if (Util.isPost(req)) {
            String publication = Util.getString(req, "textarea");
            if (publication != null) {
                //todo create
                //Publication publication1 = new Publication(0, login, password, email, 2);
                //Dao.getDao().user.create(user);
                //if (user.getId() > 0)
                    return Action.LOGIN;
            }
        }
        return null;
    }

}
