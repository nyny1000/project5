package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Item;
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
		if (keyword != null || artist != null || categoryId != null) {
			if (!StringUtils.hasLength(keyword) && artist == "all") {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for or select artist, then press the search button.");
			}
			PagedListHolder<Item> itemList;
			if (artist == "all") {
				itemList = new PagedListHolder<Item>(this.artSell.searchItemList(keyword.toLowerCase(), categoryId));
			} else {
				itemList = new PagedListHolder<Item>(this.artSell.searchItemListByArtist(keyword.toLowerCase(), artist, categoryId));
			}
			itemList.setPageSize(10);
			request.getSession().setAttribute("SearchController_itemList", itemList);
			return new ModelAndView("searchResult", "itemList", itemList);
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
			return new ModelAndView("searchResult", "itemList", itemList);
		}
		
	}
}
