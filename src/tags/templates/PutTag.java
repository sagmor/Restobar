package tags.templates;

import java.util.Hashtable;
import java.util.Stack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.BodyTagSupport;
import tags.templates.PageParameter;

public class PutTag extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	
	private String name, content, direct="false";

    // setter methods for Put tag attributes 
	public void setName(String s) { name = s; }
	public void setContent(String s) {content = s; }
	public void setDirect(String s) { direct = s; }

	public int doStartTag() throws JspException {
		

		// put a new PageParameter in the Hashtable 
		if (content == null) {
			return EVAL_BODY_BUFFERED;
		} else {
			saveParam();
			return SKIP_BODY; // not interested in tag body, if present
		}
	}
	
	@Override
	public int doAfterBody() throws JspException
	{
		BodyContent bc = getBodyContent();
		setContent(bc.getString());
		saveParam();
		
		return SKIP_BODY;
	}
	
    // tag handlers should always implement release() because
	// handlers can be reused by the JSP container 
	public void release() {
		name = content = direct = null;
	}
	
	private void saveParam() throws JspException {
		// obtain a reference to enclosing insert tag 
		InsertTag parent = (InsertTag)getAncestor(
                              "tags.templates.InsertTag");

		// put tags must be enclosed in an insert tag 
		if(parent == null)
			throw new JspException("PutTag.doStartTag(): " +
			"No InsertTag ancestor");

		// get template stack from insert tag 
		Stack<Hashtable<String,PageParameter>> template_stack = parent.getStack();
      
		// template stack should never be null 
		if(template_stack == null)
			throw new JspException("PutTag: no template stack");

		// peek at Hashtable on the stack 
		Hashtable<String,PageParameter> params = template_stack.peek();

		// Hashtable should never be null either 
		if(params == null)
			throw new JspException("PutTag: no hashtable");
		
		params.put(name, new PageParameter(content, direct));
	}
	
    // convenience method for finding ancestor names with
	// a specific class name 
	@SuppressWarnings("unchecked")
	private TagSupport getAncestor(String className)
	throws JspException {
		Class klass = null; // can't name variable "class"
		try {
			klass = Class.forName(className);
		}
		catch(ClassNotFoundException ex) {
			throw new JspException(ex.getMessage());
		}
		return (TagSupport)findAncestorWithClass(this, klass);
	}
}