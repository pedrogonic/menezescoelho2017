package lib;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Utils {
    
    /** CONFIG */
    
    public static final String BIG_DAY = "2017-11-04";
    
    /** END */
    
    
    public static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter READABLE_DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static final String READABLE_BIG_DAY = LocalDate.parse(BIG_DAY, DF).format(READABLE_DF);
    
    
    public static long daysToGo() {
        try {
            
            LocalDate bigDay = LocalDate.parse(BIG_DAY, DF);
            
            LocalDate now = LocalDate.now();
            
            return ChronoUnit.DAYS.between(now, bigDay);
            
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
