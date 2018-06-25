package by.it.kasiyanov.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet{

    ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serv(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serv(req, resp);
    }

    private void serv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Actions actions = actionFactory.defineActions(req);
        Cmd nextAction = actions.cmd.execude(req);
        if (nextAction == null){
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(actions.jsp);
            requestDispatcher.forward(req, resp);
        }
        else resp.sendRedirect("do?command" + nextAction.toString().toLowerCase());

    }
}
