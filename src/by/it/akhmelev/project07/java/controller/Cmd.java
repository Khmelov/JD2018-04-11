package by.it.akhmelev.project07.java.controller;


import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Action execute(HttpServletRequest req)
            throws Exception;
}
