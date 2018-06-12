package by.it.lanevich.jd02_06;

import java.util.Date;
import java.text.*;

public class TaskA {

        public static void main(String[] args) {
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            Logger logger = Logger.getLogger();
            for (int i = 0; i < 10; i++) {
                logger.toLog(formatForDateNow.format(date)+" Error № "+i);
            }
          }
    }

