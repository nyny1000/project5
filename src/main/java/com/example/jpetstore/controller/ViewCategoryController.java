package com.example.jpetstore.controller;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.ArtSellFacade;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes({"category", "itemList"})
public class ViewCategoryController { 
	private ArtSellFacade artSell;

	@Autowired
	public void setArtSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}
	
	@RequestMapping("/shop/viewCategory")
	public String handleRequest(@RequestParam("categoryId") String categoryId, ModelMap model) throws Exception
	{
		Category category = this.artSell.getCategory(categoryId);
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.artSell.getItemListByCategory(categoryId));
		itemList.setPageSize(10);
		model.put("category", category);
		model.put("itemList", itemList);
		return "tiles/category";
	}
	
	@RequestMapping("shop/viewCategory2")
	public String handleRequest2(@RequestParam("page") String page, @ModelAttribute("category") Category category,
			@ModelAttribute("itemList") PagedListHolder<Item> itemList, BindingResult result) throws Exception
	{
		if (category == null || itemList == null) {
			throw new IllegalStateException("cannot find pre-loaded category and item list");
		}
		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		}
		return "tiles/category";
	}
}
