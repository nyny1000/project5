package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.util.WebUtils;

import com.example.artsell.service.ArtSellFacade;

@Component
public class AuctionInterceptor implements HandlerInterceptor {
	@Autowired
	private ArtSellFacade artSell;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
//		if (userSession == null) {
//			String url = request.getRequestURL().toString(); 
//			String query = request.getQueryString();
//			//ModelAndView modelAndView = new ModelAndView("tiles/loginForm"); 	// use Tiles
//			ModelAndView modelAndView = new ModelAndView("loginForm");
//			if (query != null) {
//				modelAndView.addObject("loginForwardAction", url+"?"+query);
//			}
//			else {
//				modelAndView.addObject("loginForwardAction", url);
//			}
//			throw new ModelAndViewDefiningException(modelAndView);
//		}
//		else {
//			return true;
//		}
		
		String itemId = request.getParameter("itemId");
		int state = artSell.getItemState(itemId);
		if (state != 0) {
			ModelAndView mv = new ModelAndView("alert");
			mv.addObject("msg", "경매가 종료된 상품입니다.");
			mv.addObject("url", "");
			throw new ModelAndViewDefiningException(mv);
		}
		return true;
	}
}