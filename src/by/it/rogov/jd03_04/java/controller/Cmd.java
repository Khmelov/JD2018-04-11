package by.it.rogov.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Cmd execute(HttpServletRequest req);
}
