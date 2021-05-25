package com.example.artsell.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.service.ArtSellFacade;
import com.example.artsell.service.PaintRegiValidator;


@Controller
@SessionAttributes({"userSession", "myPaintList"})
public class MyItemController {
	
	@Autowired
	private ArtSellFacade artSell;
	
	@ModelAttribute("cateList")
	public List<Category> kinds() {
		List<Category> cateList = artSell.getCategoryList();
//		List<String> cateNameList = new ArrayList<String>();
//		for(Category c : cateList)
//			cateNameList.add(c.getName());
		return cateList;
	}
	
	@ModelAttribute("item")
	public ItemForm create() {
		return new ItemForm();
	}
	
	@RequestMapping("/myitem/list")
	public String ViewMyItemList(
			@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {

		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getMyItemList(userSession.getAccount().getUserId()));
		itemList.setPageSize(2);
		model.put("myPaintList", itemList);
		//handleRequest(page, itemList);

		return "myPaintingList";
	}
	
	@PostMapping("/myitem/add")
	public String addMyItem(@Valid @ModelAttribute("item") ItemForm item, Errors result,
			@ModelAttribute("userSession") UserSession userSession, @RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
//		System.out.println(item.getBestPrice());
		
		try {
			String fileName = picture.getOriginalFilename();
			String savePath = request.getSession().getServletContext().getRealPath("/files/");
			picture.transferTo(new File(savePath + fileName));
			
			item.setPicture("/files/" + fileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * new PaintRegiValidator().validate(item, result); if (result.hasErrors()) { //
		 * System.out.println("a"); return "paintingRegister"; }
		 */
		//연제테스트
		
//		System.out.println("b");
		item.setUserId(userSession.getAccount().getUserId());
		artSell.insertItem(item);
		
		request.getSession().setAttribute("itemSession", this.artSell.getItem(item.getItemId()));
		return "/auction/scheduler";
		//return "redirect:/myitem/list";
	}
	
	@GetMapping("/myitem/add")
	public String goEnterPaintPage() {
		
		return "paintingRegister";
	}
	
	@RequestMapping("/myitem/delete")
	public String deleteMyItem(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("itemId") String itemId, ModelMap model, HttpServletResponse response) throws Exception {
		String userId = userSession.getAccount().getUserId();
		if(artSell.isAuctioning(itemId) == 0)
			artSell.deleteItem(userId, itemId);
		else {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('경매 참여자가 있으므로 삭제할 수 없습니다.'); history.go(-1);</script>");
            out.flush();
		}
			//model.put("alertmsg", "true");

		return "redirect:/myitem/list";
	}
	
	@RequestMapping("/myitem/list2")
	public String handleRequest2(
		@RequestParam("page") String page, 
		@ModelAttribute("myPaintList") PagedListHolder<Item> itemList,
		BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		return "myPaintingList";
	}
}
