package tags;

import dto.BestPerson;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class BestmenTag extends SimpleTagSupport {

    private BestPerson bestPerson;

    public BestPerson getBestPerson() {
        return bestPerson;
    }

    public void setBestPerson(BestPerson bestPerson) {
        this.bestPerson = bestPerson;
    }
    
       
    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            
            out.println("<h1>" + bestPerson.getName() + "</h1>");
            
            out.println("<p>" + bestPerson.getText()+ "</p>");
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in BestmenTag tag", ex);
        }
    }
    
}
