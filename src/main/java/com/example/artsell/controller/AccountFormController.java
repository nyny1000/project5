package com.example.artsell.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.ArtSellFacade;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park 
 * 나영 수정1
 */
@Controller
@RequestMapping({ "/user/register.do", "/user/update.do" }) //do 빼아하나
public class AccountFormController {

	@Value("EditAccountForm")
	private String formViewName;
	
	//회원가입 or 회원정보 수정 성공 시 가게 되는 뷰 (원래는 index)
	@Value("main")
	private String successViewName;

	@Autowired
	private ArtSellFacade artsell;

	public void setArtSell(ArtSellFacade artsell) {
		this.artsell = artsell;
	}

	@Autowired
	private AccountFormValidator validator;

	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) { // edit an existing account
			return new AccountForm(artsell.getAccount(userSession.getAccount().getUserId())); // 아이디를 이용해서 가져오도록 수정.
		} else { // create a new account
			return new AccountForm();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("accountForm") AccountForm accountForm, BindingResult result) throws Exception {

		validator.validate(accountForm, result);

		if (result.hasErrors())
			return formViewName;

		try {
			if (accountForm.isNewAccount()) {
				artsell.insertAccount(accountForm.getAccount());
			} else {
				artsell.updateAccount(accountForm.getAccount());
			}
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName;
		}

		UserSession userSession = new UserSession(artsell.getAccount(accountForm.getAccount().getUserId())); //userId로 수정.
	
		session.setAttribute("userSession", userSession);
		return successViewName;
	}
}
