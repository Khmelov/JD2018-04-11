package by.it.shumilov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Util {

    public static final String POST = "post";
    public static final String STRING = ".+";

    static  boolean isPost(HttpServletRequest req){
        return  req
                .getMethod().equalsIgnoreCase(POST);
    }


    private static String getString(HttpServletRequest req, String field, String pattern){
        String value = req .getParameter(field);
        if(value.matches(pattern))
            return value;
        else {
            req.setAttribute("help_"+field, field + " incorrect");
            return null;}
    }

    static String getString(HttpServletRequest req, String field){
        //to SQL-injection
       return  getString(req,field,STRING);
    }

    static Integer getInteger(HttpServletRequest req, String field){
        String value = getString(req,field,"-?[0-9]+");
        return  value == null?null:Integer.valueOf(value);
    }
}
