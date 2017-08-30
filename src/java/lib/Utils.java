package lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.servlet.http.HttpServletRequest;


public class Utils {
    
    /** CONFIG */
    
    public static final String BIG_DAY = "2017-11-04";
    public static final String PERSONAL_EMAIL = "pedrogonic@gmail.com";
    public static final String EVENT_EMAIL = "menezescoelho2017@gmail.com";
    public static final String SUBJECT = "menezescoelho2017 hotsite";
    
    public static final dao.DAOFactory.Type DEFAULT_DB = dao.DAOFactory.Type.POSTGRES;
    
    /** END */
    
    public static final String TEST_REQUEST_URI = "/menezescoelho2017";
    public static final String ROOT_REQUEST_URI = "/";
    public static final String FB_DEFAULT_PROFILE_PIC = "/img/icons/fb-no-profile.jpg";
    public static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter READABLE_DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static final String READABLE_BIG_DAY = LocalDate.parse(BIG_DAY, DF).format(READABLE_DF);
    
    public enum Page implements AutoCloseable {
        INDEX ("jsp/index.jsp"), ABOUT ("jsp/about.jsp"), RSVP ("jsp/index.jsp")
        , MSG ("jsp/messages.jsp"), CEREMONY ("jsp/index.jsp"), PARTY ("jsp/index.jsp")
        , SHOWER ("jsp/index.jsp"), BESTMEN ("jsp/index.jsp"), GIFT ("jsp/index.jsp")
        , ERROR ("jsp/error.jsp"), SURPRISE ("jsp/surprise.jsp");
        
        private final String pageName;
        
        private Page(String pageName) { this.pageName = pageName;}
        
        public static Page fromString(String text) {
            
            if ( text.equals("") )
                return Page.INDEX;
            
            for (Page p : Page.values()) {
                if (p.getPageName().equalsIgnoreCase(text)) {
                    return p;
                }
            }
            return ERROR;
        
        }
        
        public String getPageName() { return this.pageName; }
        
        @Override
        public void close() {}
    }
      
    
    public static long daysToGo() {
        try {
            
            LocalDate bigDay = LocalDate.parse(BIG_DAY, DF);
            
            LocalDate now = LocalDate.now();
            
            return ChronoUnit.DAYS.between(now, bigDay);
            
        } catch(Exception e) {
            return 0;
        }
    }
    
    public static boolean isMobile(HttpServletRequest request) {
        
        return request.getHeader("User-Agent").toLowerCase().contains("mobi");
        
    }
    
    public static Page stripPageNameFromRequestURI (String page) {
        
        if (page == null || page.equals("null"))
            return Page.INDEX;
        else {
            page = page.replace(TEST_REQUEST_URI, "");
            page = page.replaceFirst(ROOT_REQUEST_URI, "");
            return Page.fromString(page);
        }
        
    }
    
}
