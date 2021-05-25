package com.example.artsell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired

	@Qualifier(value = "signonInterceptor")
	private HandlerInterceptor interceptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("main"); //로고 눌렀을 때 메인페이지
		registry.addViewController("/user/main").setViewName("main");

	}

	/*
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(interceptor).addPathPatterns(); }
	 */
	/*
	 * "/shop/editAccount.do", "/shop/listOrders.do", "/shop/viewOrder.do",
	 * "/shop/newOrder.do"
	 */

}
