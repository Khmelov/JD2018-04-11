package by.it.tarasiuk.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Util {
    private static final String POST = "post";
    private static final String STRING = ".+";
    private static final String INTEGER = "-?[0-9]+";
    private static final String LONG = "-?[0-9]+";
    private static final String DOUBLE = "-?[0-9]+\\.?([0-9]*)";

    private static String getString(HttpServletRequest req, String field, String pattern) {
        String value = req.getParameter(field);
        if (value.matches(pattern)) return value;
        else {
            req.setAttribute("help_" + field, field + "incorrect");
            return null;
        }
    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase(POST);
    }

    static String getString(HttpServletRequest req, String filed) {
        return getString(req, filed, STRING);
    }

    static Integer getInteger(HttpServletRequest req, String filed) {
        String value = getString(req, filed, INTEGER);
        if (value == null) {
            return null;
        } else {
            return Integer.valueOf(value);
        }
    }

    static Long getLong(HttpServletRequest req, String filed) {
        String value = getString(req, filed, LONG);
        if (value == null) {
            return null;
        } else {
            return Long.valueOf(value);
        }
    }

    static Double getDouble(HttpServletRequest req, String filed) {
        String value = getString(req, filed, DOUBLE);
        if (value == null) {
            return null;
        } else {
            return Double.valueOf(value);
        }
    }
}

