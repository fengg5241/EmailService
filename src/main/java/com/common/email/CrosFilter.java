package com.sc.fm.com.cissvcauthentication.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CrosFilter implements Filter {
	private static final Logger log = Logger.getLogger(CrosFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String origin = req.getHeader("Origin");
		
		log.info("=============== doFilter info ===================");
		log.info("origin:" + origin);
		
		if (!org.springframework.util.StringUtils.isEmpty(origin)) {
			res.addHeader("Access-Control-Allow-Origin", origin);			
		}
		
		res.addHeader("Access-Control-Allow-Methods", "*");
		
		String headers = req.getHeader("Access-Control-Request-Headers");
		
		if (!org.springframework.util.StringUtils.isEmpty(headers)) {
			res.addHeader("Access-Control-Allow-Headers", headers);			
		}
		
		res.addHeader("Access-Control-Max-Age", "3600");
		
		// enable cookie
		res.addHeader("Access-Control-Allow-Credentials", "true");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
