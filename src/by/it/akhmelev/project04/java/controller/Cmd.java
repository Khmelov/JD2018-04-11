package by.it.akhmelev.project04.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Cmd execute(HttpServletRequest req);
}
