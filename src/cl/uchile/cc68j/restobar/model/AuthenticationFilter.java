package cl.uchile.cc68j.restobar.model;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter{
	
	@SuppressWarnings("unused")
	private FilterConfig filter_conf;
	
	@Override
	public void destroy() {
		
		this.filter_conf = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig f) throws ServletException {
		
		this.filter_conf = f;
		
	}
}
