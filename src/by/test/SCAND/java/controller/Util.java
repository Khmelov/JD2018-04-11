package by.test.SCAND.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Util {

    private static  final String POST = "post";
    private static  final String STRING = ".+";
    private static  final String INTEGER = "-?[0-9]+";
    private static  final String DOUBLE = "-?[0-9]+\\.?([0-9]*)";


    private static String getString(HttpServletRequest request, String field, String pattern){
        String value = request.getParameter(field);
        if (value.matches(pattern)){
            return value;
        }
        else {
            request.setAttribute("help_" + field, field + " incorrect");
            return null;
        }
    }
    static boolean isPost(HttpServletRequest request){
        return request.getMethod().equalsIgnoreCase(POST);
    }

    static String getString(HttpServletRequest request, String filed){
        return getString(request,filed,STRING);
    }

    static Integer getInteger(HttpServletRequest request,String field){
        String value = getString(request,field,INTEGER);
        return value == null ? null : Integer.valueOf(value);
    }
    static Double getDouble(HttpServletRequest request,String field){
        String value = getString(request,field,DOUBLE);
        return value == null ? null : Double.valueOf(value);
    }

}
