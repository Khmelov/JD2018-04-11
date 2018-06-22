package by.it.kashayed.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Cmd excecude(HttpServletRequest req);
}
