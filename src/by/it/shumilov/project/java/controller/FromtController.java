package by.it.shumilov.project.java.controller;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FromtController extends HttpServlet {

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



    private  void  serv(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
       Actions action = actionFactory.defineAction(req);
       Cmd nexAction = action.cmd.execute((HttpRequest) req);
       if (nexAction == null){
           ServletContext servletContext = getServletContext();
           RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.jsp);
            requestDispatcher.forward(req, resp);
       }
       else  {
           resp.sendRedirect("do?command"+ nexAction.toString().toLowerCase());
       }
    }


}
