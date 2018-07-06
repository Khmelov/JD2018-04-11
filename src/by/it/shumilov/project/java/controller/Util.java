package by.it.shumilov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

class Util {
    private static final String NUMBER = "\\d{12}";
    private static final String POST = "post";
    private static final String STRING = ".+";
    private static final String GOS = ".{9}";
    private static final String YEAR = "\\d{4}";
    private static final String VIN = ".{17}";
    private static final String INTEGER = "-?[0-9]+";
    private static final String LONG = "-?[0-9]+";
    private static final String DOUBLE = "-?[0-9]+\\.?([0-9]*)";
    private static final String DATE = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" +
                                            "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$" +
                                            "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" +
                                            "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
    private static final String EMAIL = "^(|(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)" +
                                            "|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+" +
                                            "@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6})$";

    static  boolean isPost(HttpServletRequest req){
        return  req
                .getMethod().equalsIgnoreCase(POST);
    }


    private static String getString(HttpServletRequest req, String field, String pattern){
        String value = req.getParameter(field);
        if(value != null && value.matches(pattern))
            return value;
        else {
            req.setAttribute("help_"+field, field + " incorrect");
            return null;
        }
    }



    static String getString(HttpServletRequest req, String field){
        //to SQL-injection
       return  getString(req,field,STRING);
    }

    static Integer getInteger(HttpServletRequest req, String field){
        String value = getString(req,field,INTEGER);
        return  value == null?null:Integer.valueOf(value);
    }


    static String getNumber(HttpServletRequest req, String field){
        String value = getString(req,field,NUMBER);
        return  value == null?null:String.valueOf(value);
    }

    static String getEmail(HttpServletRequest req, String field){
        String value = getString(req,field,EMAIL);
        return  value == null?null:String.valueOf(value);
    }

    static Double getDouble(HttpServletRequest req, String field){
        String value = getString(req,field,DOUBLE);
        return  value == null?null:Double.valueOf(value);
    }

    static Long getLong(HttpServletRequest req, String field){
        String value = getString(req,field,LONG);
        return  value == null?null:Long.valueOf(value);
    }

    static String getGos(HttpServletRequest req, String field){
        //to SQL-injection
        return  getString(req,field,GOS);
    }

    static String getVin(HttpServletRequest req, String field){
        //to SQL-injection
        return  getString(req,field,VIN);
    }

    static Integer getYear(HttpServletRequest req, String field){
        String value = getString(req,field,YEAR);
        return  value == null?null:Integer.valueOf(value);
    }


    static Date getData(HttpServletRequest req, String field){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String value = getString(req,field,DATE);
        try {

            return sdf.parse(value);

        } catch (Exception ex) {

            req.setAttribute("help_"+field, field + " incorrect");
            return null;
        }

    }


}
