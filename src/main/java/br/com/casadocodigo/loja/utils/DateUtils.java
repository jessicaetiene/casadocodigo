package br.com.casadocodigo.loja.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String FORMATO_DD_MM_YY = "dd/MM/yy";

    public static Calendar localDateToCalendar(LocalDate localDate) {
        if(localDate == null){
            return null;
        }

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
