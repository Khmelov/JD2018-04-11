package by.it.kurmaz.project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Actions execute(HttpServletRequest req) throws Exception;
}
