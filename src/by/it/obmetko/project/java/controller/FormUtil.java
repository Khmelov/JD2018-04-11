package by.it.obmetko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {
    private static final String POST = "post";
    private static final String STRING = ".+";
    private static final String INTEGER = "-?[0-9]+";
    private static final String LONG = "-?[0-9]+";
    private static final String DOUBLE = "-?[0-9]+\\.?([0-9]*)";

    public static String getString(String value, String regex) {
        if(value==null) return null;
        else if (value.matches(regex)) return value;
        else return null;
    }

    public static Integer getInt(String value) {
               if(value!=null) return Integer.parseInt(value);
               else return null;
            }
    public static boolean isPost(HttpServletRequest reg) {
        return reg.getMethod().toUpperCase().equals("POST");
    }
    private static String getString(HttpServletRequest req, String field, String pattern) {
        String value = req.getParameter(field);
        if (value.matches(pattern))
            return value;
        else {
            req.setAttribute("help_"+field, field+" incorrect");
            return null;
        }
    }
    static Integer getInteger(HttpServletRequest req, String field) {
        String value = getString(req, field, INTEGER);
        return value == null ? null : Integer.valueOf(value);
    }

   public static Long getLong(HttpServletRequest req, String field) {
        String value = getString(req, field, LONG);
        return value == null ? null : Long.valueOf(value);
    }

    static Double getDouble(HttpServletRequest req, String field) {
        String value = getString(req, field, DOUBLE);
        return value == null ? null : Double.valueOf(value);

    }
    public static String getString(HttpServletRequest req, String field) {
        //fix it
        return getString(req, field, STRING);
    }



}
