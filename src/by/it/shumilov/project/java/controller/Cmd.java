package by.it.shumilov.project.java.controller;

import com.sun.deploy.net.HttpRequest;

abstract class Cmd {
    abstract  Cmd execute(HttpRequest req);
}
