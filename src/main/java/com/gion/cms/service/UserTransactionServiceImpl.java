package com.gion.cms.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gion.cms.entity.TUserTransaction;
import com.gion.cms.mapper.TUserTransactionMapper;

@Service
public class UserTransactionServiceImpl implements UserTransactionService {

	@Resource
	private TUserTransactionMapper tranMapper;
	
	@Override
	public TUserTransaction getTransactionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TUserTransaction record) {
		tranMapper.insert(record);
	}

	@Override
	public void update(TUserTransaction userTransaction) {
		tranMapper.updateByPrimaryKey(userTransaction);

	}

	@Override
	public void delete(TUserTransaction userTransaction) {
		tranMapper.softDelete(userTransaction);

	}

	@Override
	public List<TUserTransaction> getAll() {
		return tranMapper.selectAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public BigDecimal getPointByUserId(int id) {
//		List<TUserTransaction> list = tranMapper.selectAllByUserId(id);
//		BigDecimal totalPoint = BigDecimal.ZERO;
//		for (TUserTransaction l : list) {
//			if(l.getType() == 1) {
//				totalPoint = totalPoint.add(l.getPayment()).subtract(l.getPoint());
//			}else {
//				totalPoint = totalPoint.add(l.getPayment()).subtract(l.getPoint());
//			}
//		}
//		return totalPoint;
//	}

	@Override
	public List<TUserTransaction> getAllByPhone(String phone) {
		return tranMapper.selectAllByPhone(phone);
	}

}
