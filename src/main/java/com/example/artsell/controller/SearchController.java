package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
public class SearchController {
	private ArtSellFacade artSell;
	
	@Autowired
	public void setArtSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}
	
	@RequestMapping("/search/item")
	public ModelAndView handleRequest(HttpServletRequest request, @RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="artist", required=false) String artist, @RequestParam(value="categoryId", required=false) String categoryId,
			@RequestParam(value="page", required=false) String page) throws Exception
	{
		if (keyword != null || artist != null) {
			if (!StringUtils.hasLength(keyword) && "all".equals(artist)) {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for or select artist, then press the search button.");
			}
			int total = this.artSell.searchItemList(keyword, artist, categoryId).size();
			PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.artSell.searchItemList(keyword, artist, categoryId));
			System.out.println("keyword: " + keyword + " artist: " + artist + " categoryId: " + categoryId);
			/*
			 * if (artist == "all") { itemList = new
			 * PagedListHolder<Item>(this.artSell.searchItemList(keyword.toLowerCase(),
			 * categoryId)); } else { itemList = new
			 * PagedListHolder<Item>(this.artSell.searchItemListByArtist(keyword.toLowerCase
			 * (), artist, categoryId)); }
			 */
			String categoryName = null;
			if (categoryId != null) {
				categoryName = this.artSell.getCategory(categoryId).getName();
			}
			itemList.setPageSize(10);
			request.getSession().setAttribute("SearchController_itemList", itemList);
			ModelAndView mv = new ModelAndView("searchResult", "itemList", itemList);
			mv.addObject("total", total);
			mv.addObject("categoryName", categoryName);
			return mv;
		} else {
			@SuppressWarnings("unchecked")
			PagedListHolder<Item> itemList = (PagedListHolder<Item>)request.getSession().getAttribute("SearchController_itemList");
			if (itemList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				itemList.nextPage();
			} else if ("previous".equals(page)) {
				itemList.previousPage();
			}
			String categoryName = null;
			if (categoryId != null) {
				categoryName = this.artSell.getCategory(categoryId).getName();
			}
			int total = this.artSell.searchItemList(keyword, artist, categoryId).size();
			ModelAndView mv = new ModelAndView("searchResult", "itemList", itemList);
			mv.addObject("total", total);
			mv.addObject("categoryName", categoryName);
			return mv;
		}
		
	}
}
