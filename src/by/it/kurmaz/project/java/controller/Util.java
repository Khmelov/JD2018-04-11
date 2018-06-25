package by.it.kurmaz.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Util {
    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    private static String getString(HttpServletRequest req, String field, String pattern) {
        String value = req.getParameter(field);
        if (value.matches(pattern))
            return value;
        else
            return null;
    }

    static String getString(HttpServletRequest req, String field) {
        return getString(req, field, ".+");
    }
}
