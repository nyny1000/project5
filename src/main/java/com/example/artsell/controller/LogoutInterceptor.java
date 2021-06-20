package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LogoutInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		   System.out.println("logoutInterceptor");
		   response.setDateHeader("Expires", 0); 
	       response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
	       response.setHeader("Pragma", "no-cache");
	       return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		   System.out.println("logoutInterceptor2");
		   response.setDateHeader("Expires", 0); 
	       response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
	       response.setHeader("Pragma", "no-cache");
	} 
}
