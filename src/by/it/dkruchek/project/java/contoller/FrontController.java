package by.it.dkruchek.project.java.contoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "FrontController", urlPatterns = "/do")
public class FrontController extends HttpServlet {

    ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serve(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serve(req, resp);

    }

    private void serve(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Actions action = actionFactory.defineAction(req);
        Cmd nextAction = action.cmd.execute(req);
        resp.setHeader("Cache-Control", "no-store");

        if (nextAction == null) {
            // show view
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.jsp);
            requestDispatcher.forward(req, resp);
        } else {
            // redirect web-browser to another command
            resp.sendRedirect("do?command=" + nextAction.toString().toLowerCase());
        }
    }
}
