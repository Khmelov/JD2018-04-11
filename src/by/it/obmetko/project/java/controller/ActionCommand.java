package by.it.obmetko.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public abstract class ActionCommand {
        public abstract ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException;

        public String getJSP() {
                return "/".concat(this.toString().toLowerCase()).concat(".jsp");
        }

        @Override
        public String toString() {
                return getClass().getSimpleName().replace("Command", "");
        }
}
