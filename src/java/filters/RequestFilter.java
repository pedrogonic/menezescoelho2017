package filters;

import dto.Message;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.Utils;


public class RequestFilter implements Filter {
    
    private static final boolean FILTER_DEBUG = false;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public RequestFilter() {
    }    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        
        String query = req.getRequestURI();
        System.out.println("query: "+query);
        Enumeration<String> params = req.getParameterNames();
        
        Utils.Page pageInSession = (Utils.Page) session.getAttribute("currentPage");
        if (FILTER_DEBUG)
            System.out.println("curr: "+pageInSession);
        
        Utils.Page currentURI = Utils.stripPageNameFromRequestURI(req.getRequestURI());
        if (FILTER_DEBUG)
            System.out.println("currURI: "+currentURI);
        
        // Redirect to controller if page Attribute in session is not set ot if it doesn't match URI
        if ( !( pageInSession != null && pageInSession.equals(currentURI) ) ){
            redirect(req, res, currentURI);
            return;
        }
        
        // Check for known contents and redirect if conditions are not met
        switch (currentURI) {
            
            case MSG:
                List<Message> messageList = (List)session.getAttribute("messageList");
                if(messageList == null) 
                    redirect(req, res, currentURI);
                break;
                
        }
        
//        while(params.hasMoreElements()){
//			String name = params.nextElement();
//			String value = request.getParameter(name);
//			System.out.println("Param: "+name +" val: "+value);
//		}
        
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException t) {
            // Netbeans automatic Filter implementation
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
        

        // Netbeans automatic Filter implementation
        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            //sendProcessingError(problem, response);
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void redirect(HttpServletRequest request, HttpServletResponse response, Utils.Page currentURI) {
        
        try {
            
            if (FILTER_DEBUG)
                System.out.println("Redirecting to " + currentURI);
            
            response.sendRedirect(request.getContextPath()+"/Controller?page="+currentURI);
            
        } catch (IOException e) { e.printStackTrace(); }
        
    }
    
    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (FILTER_DEBUG) {                
                log("RequestFilter:Initializing filter");
            }
        }
    }
    
    @Deprecated
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                try (PrintStream ps = new PrintStream(response.getOutputStream()); PrintWriter pw = new PrintWriter(ps)) {
                    pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N
                    
                    // PENDING! Localize this for next official release
                    pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                    pw.print(stackTrace);
                    pw.print("</pre></body>\n</html>"); //NOI18N
                }
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        } else {
            try {
                try (PrintStream ps = new PrintStream(response.getOutputStream())) {
                    t.printStackTrace(ps);
                }
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (IOException ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
