package tags.templates;

import java.util.Hashtable;
import java.util.Stack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import tags.templates.PageParameter;

public class GetTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String name;

    // setter method for name attribute 
	public void setName(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		// obtain reference to template stack 
		Stack<Hashtable<String,PageParameter>> stack = (Stack<Hashtable<String,PageParameter>>)pageContext.getAttribute(
				"template-stack", PageContext.REQUEST_SCOPE);

		// stack should not be null 
		if(stack == null)
			throw new JspException("GetTag.doStartTag(): " +
                                 "NO STACK");

		// peek at hashtable 
		Hashtable<String,PageParameter> params = stack.peek();

       // hashtable should not be null 
      if(params == null)
         throw new JspException("GetTag.doStartTag(): " +
                                 "NO HASHTABLE");

       // get page parameter from hashtable 
      PageParameter param = params.get(name);

      if(param != null) {
         String content = param.getContent();

         if(param.isDirect()) {
             // print content if direct attribute is true 
            try {
               pageContext.getOut().print(content);
            }
            catch(java.io.IOException ex) {
               throw new JspException(ex.getMessage());
            }
         }
         else {
             // include content if direct attribute is false 
            try {
               pageContext.getOut().flush();
               pageContext.include(content);
            }
            catch(Exception ex) {
               throw new JspException(ex.getMessage());
            }
         }
      }
      return SKIP_BODY; // not interested in tag body, if present 
   }
    // tag handlers should always implement release() because
   // handlers can be reused by the JSP container 
   public void release() {
      name = null;
   }
}