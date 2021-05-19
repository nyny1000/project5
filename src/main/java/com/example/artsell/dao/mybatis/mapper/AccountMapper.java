package com.example.artsell.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.artsell.domain.Account;

@Mapper
public interface AccountMapper {
	Account getAccountByUsername(String username);

	Account getAccountByUsernameAndPassword(String userId, String password);
}
