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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        serv(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        serv(req, resp);
    }

    private void serv(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0");
        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand(req);
        ActionCommand nextStep = null;
        ServletContext servletContext = getServletContext();
        try {
            nextStep = command.execute(req, resp);
        } catch (SQLException | ParseException | NullPointerException e) {
            req.setAttribute(Msg.ERROR, "FC:" + e);
                        req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(e.getStackTrace()));
                        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(Action.ERROR.command.getJSP());
                        requestDispatcher.forward(req, resp);
        }
        if (nextStep == null || nextStep == command) {
                        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(command.getJSP());
                        requestDispatcher.forward(req, resp);
                    } else resp.sendRedirect("do?command=" + nextStep);

    }
}