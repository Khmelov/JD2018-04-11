package by.it.krivenkova.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Cmd {
    abstract Actions execute(HttpServletRequest req)
            throws Exception;

/*    abstract Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                .replaceFirst("Cmd", "");
    }

    public String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }*/
}
