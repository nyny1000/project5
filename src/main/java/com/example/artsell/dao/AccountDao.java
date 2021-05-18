package com.example.artsell.dao;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Account;

public interface AccountDao {
	Account getAccount(String username) throws DataAccessException;

	Account getAccount(String userId, String password) throws DataAccessException;
}
