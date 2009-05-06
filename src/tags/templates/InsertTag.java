package tags.templates;

import java.util.Hashtable;
import java.util.Stack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class InsertTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String template;
	private Stack<Hashtable<String,PageParameter>> stack;

    // setter method for template attribute 
	public void setTemplate(String template) {
		this.template = template;
	}
   
	public int doStartTag() throws JspException {
		stack = getStack(); // obtain a reference to the template stack 
		stack.push(new Hashtable<String,PageParameter>()); // push new hashtable onto stack 
		return EVAL_BODY_INCLUDE; // pass tag body through unchanged 
	}
   
	public int doEndTag() throws JspException {
		try {
			pageContext.include(template); // include template 
		}
		catch(Exception ex) { // IOException or ServletException 
			throw new JspException(ex.getMessage()); // recast exception 
		}
		stack.pop(); // pop hashtable off stack 
		return EVAL_PAGE; // evaluate the rest of the page after the tag 
	}
	
	// tag handlers should always implement release() because
	// handlers can be reused by the JSP container 
	public void release() {
		template = null;
		stack = null;
	}
	
	
	@SuppressWarnings("unchecked")
	public Stack<Hashtable<String,PageParameter>> getStack() {
		// try to get stack from request scope 
		Stack<Hashtable<String,PageParameter>> s = (Stack<Hashtable<String,PageParameter>>)pageContext.getAttribute(
                        "template-stack",
                        PageContext.REQUEST_SCOPE);

		// if the stack's not present, create a new one and
		// put it into request scope 
		if(s == null) {
			s = new Stack();
			pageContext.setAttribute("template-stack", s,
					PageContext.REQUEST_SCOPE);
		}
		return s;
   }
}