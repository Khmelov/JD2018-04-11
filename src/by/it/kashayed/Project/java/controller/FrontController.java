package by.it.kashayed.Project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private ActionFactory actionFactory;
    private ServletContext servletContext;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
        servletContext = getServletContext();
    }

    private void serv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().write("FrontController");
        try {
            Action action = actionFactory.defineAction(req);
            Action nextAction = action.cmd.execute(req);
            if (nextAction == null) {
                // ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.jsp);
                requestDispatcher.forward(req, resp);
            } else
                resp.sendRedirect("do?command=" + nextAction.toString().toLowerCase());
        } catch (Exception e) {
            errShow(req, resp, e);
        }
    }

    private void errShow(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        req.setAttribute("errMassage", e.toString());
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement).append("<br>");
            if (stackTraceElement.toString().contains(".FrontController."))
                break;
        }
        req.setAttribute("errStack", sb.toString());
        RequestDispatcher rd=servletContext.getRequestDispatcher(Action.ERROR.jsp);
        rd.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serv(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serv(req, resp);

    }

}
