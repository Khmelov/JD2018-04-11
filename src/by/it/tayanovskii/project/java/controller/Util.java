package by.it.tayanovskii.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Util {

    private static final String POST = "post";
    private static final String STRING = ".+";
    private static final String INTEGER = "-?[0-9]+";
    private static final String DOUBLE = "-?[0-9]+\\.?([0-9]*)";
    //private static final String EMAIL = "^[a-zA-Z0-9]{1,}+((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})* + @ + [a-zA-Z0-9]{1,} + ((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})* + \\.[a-zA-Z]{2,}$";
    //private static final String LOGIN = "^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$";

    private static final Pattern EMAIL = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern LOGIN = Pattern.compile("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$");

    private static Matcher matcher;

    private static String getString(HttpServletRequest req, String field, String pattern) {
        String value = req.getParameter(field);
        if (value.matches(pattern))
            return value;
        else {
            req.setAttribute("help_"+field, field+" incorrect");
            return null;
        }
    }

    static String getEmail (HttpServletRequest req, String field)
    {
        matcher = EMAIL.matcher(getString(req,field));
        if(matcher.matches()) {
            return getString(req, field);
        } else return null;
    }

    static String getLogin (HttpServletRequest req, String field)
    {
        matcher = LOGIN.matcher(getString(req,field));
        if(matcher.matches()) {
            return getString(req, field);
        } else return null;
    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase(POST);
    }

    static String getString(HttpServletRequest req, String field) {
        //todo SQL injection (fix it)
        return getString(req, field, STRING);
    }

    static Integer getInteger(HttpServletRequest req, String field) {
        String value = getString(req, field, INTEGER);
        return value == null ? null : Integer.valueOf(value);
    }

    static Double getDouble(HttpServletRequest req, String field) {
        String value = getString(req, field, DOUBLE);
        return value == null ? null : Double.valueOf(value);
    }

}
