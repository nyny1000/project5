package com.example.artsell.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.artsell.controller.AccountForm;
import com.example.artsell.domain.Account;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park 나영 수정1
 */
@Component
public class AccountFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AccountForm accountForm = (AccountForm) obj;
		Account account = accountForm.getAccount();

		// 에러 코드 수정완료.

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.name", "USER_NAME_REQUIRED",
				"User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_REQUIRED",
				"Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phone", "PHONE_REQUIRED",
				"Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address1", "ADDRESS1_REQUIRED",
				"Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address2", "ADDRESS2_REQUIRED",
				"Address Detail is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.credit", "CREDIT_REQUIRED",
				"Credit card is required.");

		if (accountForm.isNewAccount()) {
			System.out.println("새 계정");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.userId", "USER_ID_REQUIRED",
					"User ID is required.");
			if (account.getPassword() == null || account.getPassword().length() < 1
					|| !account.getPassword().equals(accountForm.getRepeatedPassword())) {
				System.out.println("비번 안 맞음");
				errors.rejectValue("account.password", "PASSWORD_MISMATCH");
				// errors.reject("PASSWORD_MISMATCH","Passwords did not match or were not
				// provided. Matching passwords are required.");
			}
		} else if (account.getPassword() != null && account.getPassword().length() > 0) {
			if (!account.getPassword().equals(accountForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			}
		}
	}
}