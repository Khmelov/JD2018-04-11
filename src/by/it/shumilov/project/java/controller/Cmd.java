package by.it.shumilov.project.java.controller;


import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract  Cmd execute(HttpServletRequest req);
}
