package by.it.kasiyanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Cmd execude(HttpServletRequest req);
}
