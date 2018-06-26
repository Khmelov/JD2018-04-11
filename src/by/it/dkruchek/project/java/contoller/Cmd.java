package by.it.dkruchek.project.java.contoller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req);

}
