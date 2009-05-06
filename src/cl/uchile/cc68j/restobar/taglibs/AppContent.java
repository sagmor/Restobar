package cl.uchile.cc68j.restobar.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException; 
import javax.servlet.jsp.JspWriter; 
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class AppContent extends BodyTagSupport {
	
	private static final long serialVersionUID = 1L;
	private String title;
	
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();
		try {
			out.print(header());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new JspException(ex);
		}
		return super.doStartTag();
	}

	@Override
	public int doAfterBody() throws JspException
	{
		try {
			BodyContent bc = getBodyContent();
			JspWriter out = bc.getEnclosingWriter();
			out.print(bc.getString());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new JspException(ex);
		}
		return super.doAfterBody();
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print(footer());
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new JspException(ex);
		}
		return super.doEndTag();
	}
	
	private String header(){
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\"\n" +
		"\"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\n" +
		"<html><head><title>"+title+"</title></head><body>";
	}
	
	private String footer() {
		return "</body></html>";
	}
}
