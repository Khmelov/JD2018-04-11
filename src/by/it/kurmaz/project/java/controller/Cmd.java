package by.it.kurmaz.project.java.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Cmd {
    abstract ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
