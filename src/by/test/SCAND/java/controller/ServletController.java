package by.test.SCAND.java.controller;

import by.test.SCAND.java.bean.Clients;
import by.test.SCAND.java.dao.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServletController extends HttpServlet {

   private ActionFactory actionFactory;
   private ServletContext servletContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Actions actions = actionFactory.defineAction(req);
            Actions nexAction = actions.cmd.execute(req);
        if(nexAction==null){
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(actions.jsp);
            requestDispatcher.forward(req,resp);
        }
        else {
            resp.sendRedirect("do?command="+nexAction.toString().toLowerCase());
        }
        } catch (Exception e) {
            showError(req, resp, e);
        }
    }

    @Override
    public void init() throws ServletException {
        actionFactory= new ActionFactory();
        servletContext = getServletContext();
        List<Clients> roles = null;
        try{
            roles= Dao.getDao().clients.getAll("");
            servletContext.setAttribute("clients",roles);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void showError(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        req.setAttribute("errMessage", e.toString());
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            sb.append(element).append("<br>");
            if (element.toString().contains(".ServletController."))
                break;
        }
        req.setAttribute("errStack", sb.toString());
        RequestDispatcher requestDispatcher =
                servletContext.getRequestDispatcher(Actions.ERROR.jsp);
        requestDispatcher.forward(req, resp);
    }
}
