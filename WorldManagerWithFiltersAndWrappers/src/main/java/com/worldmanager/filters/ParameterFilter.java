package com.worldmanager.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worldmanager.wrappers.ParameterInspector;

/**
 * Servlet Filter implementation class ParamterInspector
 */
// / * will cause all urls to be filtered and parameter intercept 
@WebFilter("/*")
public class ParameterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ParameterFilter() {
        //do nothing
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//do nothing
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//wrap the request with the inspector
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		

		// pass the request along the filter chain
		chain.doFilter(new ParameterInspector(req), res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
