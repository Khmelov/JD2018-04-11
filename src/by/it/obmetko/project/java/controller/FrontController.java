package by.it.obmetko.project.java.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class FrontController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand(req);
        ActionCommand nextStep = null;
        ServletContext servletContext = getServletContext();
        try {
            nextStep = command.execute(req,resp);
        } catch (SQLException | ParseException | NullPointerException e) {
            req.setAttribute(Msg.ERROR, "FC:" + e);
            req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(e.getStackTrace()));
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(Actions.ERROR.command.getJSP());
            requestDispatcher.forward(req, resp);
        }
        if (nextStep == null || nextStep == command) {
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(command.getJSP());
            requestDispatcher.forward(req, resp);
        } else resp.sendRedirect("do?command=" + nextStep);

    }
    }