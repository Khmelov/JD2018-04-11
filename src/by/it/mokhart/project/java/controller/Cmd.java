package by.it.mokhart.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

abstract class Cmd {
    abstract Actions execute(HttpServletRequest req)
            throws Exception;
}
