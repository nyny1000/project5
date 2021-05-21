package com.example.artsell.service;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.ItemForm;

public class PaintRegiValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		ItemForm model = (ItemForm) obj;
		
		MultipartFile file = model.getPicture();
		
		if(file.isEmpty()){
            errors.rejectValue("picture", "upload.file.required");
        }
	
//	    for (CommonsMultipartFile multipartFile: commonsMultipartFiles) {
//	        if (multipartFile.getSize() == 0) {
//	            errors.rejectValue("files", "myapplication.missing.file");
//	        }
//	    }
	}

}
