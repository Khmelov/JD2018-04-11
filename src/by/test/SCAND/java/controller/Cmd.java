package by.test.SCAND.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Actions execute(HttpServletRequest request) throws Exception;
}
