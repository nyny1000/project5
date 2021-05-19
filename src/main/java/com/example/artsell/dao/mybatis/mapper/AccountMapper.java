package com.example.artsell.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.artsell.domain.Account;

@Mapper
public interface AccountMapper {
	Account getAccountByUserId(String userId);

	Account getAccountByUsernameAndPassword(String username, String password);

	List<String> getUsernameList();

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	List<Account> viewAccountList();

}
