package com.gion.cms.service;

import java.math.BigDecimal;
import java.util.List;

import com.gion.cms.entity.TUserTransaction;

public interface UserTransactionService {

	TUserTransaction getTransactionById(int id);
	
	List<TUserTransaction> getAll();
	
	List<TUserTransaction> getAllByPhone(String phone);
	
//	BigDecimal getPointByUserId(int id);
	
	void insert(TUserTransaction record);
	
	void update(TUserTransaction record);
	
	void delete(int id);

	void delete(TUserTransaction userTransaction);
}
