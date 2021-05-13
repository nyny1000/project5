package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
public class InterestingListController {

	@Autowired
	private PetStoreFacade artSell;
	// private ArtSellFacade artSell;

	@RequestMapping("/interesting/list")
	public ModelAndView viewInterestingList(@RequestParam(value = "page", required = false) String page,
			@ModelAttribute("userSession") UserSession userSession) throws Exception {
		// List<Item> interestList = new
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getInterestingItemList(userSession.getAccount().getUserId()));
		itemList.setPageSize(5);
		handleRequest(page, itemList);

		return new ModelAndView("myInterestingList", "interestList", itemList.getPageList());
	}
	
	@RequestMapping("/interesting/add")
	public String addItemToInterestingList(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("interItemId") String itemId, ModelMap model) {
		String userId = artSell.getInterestingItemList(userSession.getAccount().getUserId());
		if(artSell.containsInterestingItem(userId, itemId) == 1) {
			model.addAttribute("intermsg", "이미 찜하였습니다.");
		}
		else {
			artSell.insertInterestingItem(userId, itemId);
			model.addAttribute("intermsg", "찜 되었습니다.");
		}
		
		return "paintingDetail";
	}
	
	
	@RequestMapping("/interesting/delete")
	public String deleteItemFromInterestingList(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("interItemId") String itemId) {
		String userId = artSell.getInterestingItemList(userSession.getAccount().getUserId());
		artSell.deleteItemFromInterestingList(userId, itemId);

		return "redirect:/interesting/list";
	}

	private void handleRequest(String page, PagedListHolder<Item> itemList) throws Exception {

		if ("nextCart".equals(page)) {
			itemList.nextPage();
		} else if ("previousCart".equals(page)) {
			itemList.previousPage();
		}
	}
}
