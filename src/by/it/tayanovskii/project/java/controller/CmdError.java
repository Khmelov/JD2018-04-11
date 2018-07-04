package by.it.tayanovskii.project.java.controller;

import by.it.tayanovskii.project.java.beans.Publication;
import by.it.tayanovskii.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdError extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        return null;
    }
}
