package by.it.gavrilchik.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    ActionFactory actionFactory;
    ServletContext servletContext;
    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
        servletContext = getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serv(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serv(req, resp);
    }

    private void serv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Actions action = actionFactory.defineAction(req);
            Cmd nextAction = action.cmd.execute(req);
            if (nextAction == null) {

                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.jsp);
                requestDispatcher.forward(req, resp);

            } else {
                resp.sendRedirect("do?command=" + nextAction.toString().toLowerCase());
            }
        } catch (Exception e) {
            req.setAttribute("errMessage",e.toString());
            StringBuilder sb=new StringBuilder();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                sb.append(element).append("<br>");
                if (element.toString().contains(".FrontController."))
                    break;
            }
            req.setAttribute("errStack",sb.toString());
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(Actions.ERROR.jsp);
            requestDispatcher.forward(req, resp);
        }
    }
}
