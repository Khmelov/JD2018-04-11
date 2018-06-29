package by.it.dkruchek.project.java.contoller;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class CmdVacation extends Cmd {

    Calendar calendar;

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (!Util.isPost(req)) {
            calendar = Calendar.getInstance();
            String currDate = new SimpleDateFormat("dd.MM.YYYY").format(calendar.getTime());
            req.setAttribute("tomorrow", currDate);
        } else {
            Date startDate = Util.getDate(req, "start_date");
            Date endDate = Util.getDate(req, "end_date");
            System.out.println("start: " + startDate);
            System.out.println("start: " + endDate);
        }
        return null;
    }
}
