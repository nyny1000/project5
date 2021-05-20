package com.example.artsell.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.AccountDao;
import com.example.artsell.dao.mybatis.mapper.AccountMapper;
import com.example.artsell.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {
	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccount(String username) throws DataAccessException {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String userId, String password) 
			throws DataAccessException {
		return accountMapper.getAccountByUsernameAndPassword(userId, password);
	}
}
