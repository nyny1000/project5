package com.example.artsell.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;


@Controller
@SessionAttributes("userSession")
public class MyItemController {
	
	@Autowired
	private ArtSellFacade artSell;
	
	@ModelAttribute("cateList")
	public List<Category> kinds() {
		List<Category> cateList = artSell.getCategoryList();

		return cateList;
	}
	
	@RequestMapping("/myitem/list")
	public ModelAndView ViewMyItemList(@RequestParam(value = "page", required = false) String page,
			@ModelAttribute("userSession") UserSession userSession) throws Exception {

		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getMyItemList(userSession.getAccount().getUserId()));
		itemList.setPageSize(5);
		handleRequest(page, itemList);

		return new ModelAndView("myPaintingList", "mypaintList", itemList.getPageList());
	}
	
	@RequestMapping("/myitem/add")
	public String addMyItem(@Valid @ModelAttribute("item") Item item, Errors result,
			@ModelAttribute("userSession") UserSession userSession) {
		 
		if (result.hasErrors()) {
			return "paintingRegister";
		}
		item.setUserId(userSession.getAccount().getUserId());
		artSell.insertItem(item);	
		return "redirect:/myitem/list";
	}
	
	@RequestMapping("/myitem/delete")
	public String deleteMyItem(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("myItemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		artSell.deleteItem(userId, itemId);

		return "redirect:/myitem/list";
	}
	
	private void handleRequest(String page, PagedListHolder<Item> itemList) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		}
	}

}
