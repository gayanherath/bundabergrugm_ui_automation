package com.sysco.web_ui_automation.qe.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private DateUtils(){}

    public static String getPastOrFutureDate(int numOfYears,int numOfDays) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, numOfYears);
        calendar.add(Calendar.DAY_OF_MONTH, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String pastDate = sdf.format(date);

        return pastDate;
    }

}
