package com.example.artsell.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.AccountDao;
import com.example.artsell.dao.mybatis.mapper.AccountMapper;
import com.example.artsell.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountmapper;
	@Override
	public Account getAccount(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return accountmapper.getAccountByUserId(userId);
	}

	@Override
	public Account getAccount(String userId, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		return accountmapper.getAccountByUsernameAndPassword(userId, password);
	}

	@Override
	public void insertAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		accountmapper.insertAccount(account);
		
	}

	@Override
	public void updateAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		accountmapper.updateAccount(account);
	}

	@Override
	public List<String> getUsernameList() throws DataAccessException {
		// TODO Auto-generated method stub
		return accountmapper.getUsernameList();
	}

	@Override
	public List<Account> viewAccountList() throws DataAccessException {
		// TODO Auto-generated method stub
		return accountmapper.viewAccountList();
	}


}
