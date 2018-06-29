package by.it.shumilov.project.java.controller;



import by.it.shumilov.project.java.beans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class FromtController extends HttpServlet {

    private ActionFactory actionFactory;
    private ServletContext servletContext;

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



    private  void  serv(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        try{

            HttpSession session = req.getSession();
            Object oUser = session.getAttribute("user");
            if(oUser!=null){
                User user = (User) oUser;
                Cookie cookieName = new Cookie("user",user.getLogin());
                cookieName.setMaxAge(60);
                Cookie cookiePass = new Cookie("password",user.getPassword());
                cookiePass.setMaxAge(60);
                resp.addCookie(cookieName);
                resp.addCookie(cookiePass);
            }

        resp.setHeader("Cache-Control", "no-store");
        Action action = actionFactory.defineAction(req);
       Action nexAction = action.cmd.execute(req);

       if (nexAction == null){

           RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.jsp);

           requestDispatcher.forward(req, resp);

       }
       else  {

           resp.sendRedirect("do?command="+ nexAction.toString().toLowerCase());
       }
        }
       catch (Exception e){
           showError(req, resp, e);
       }
    }

    private void showError(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        req.setAttribute("errMessage",e.toString());
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            sb.append(element).append("<br>");
            if(element.toString().contains(".FrontController."))
                break;
        }
        req.setAttribute("errStack",sb.toString());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(Action.ERROR.jsp);

        requestDispatcher.forward(req, resp);
    }


}
