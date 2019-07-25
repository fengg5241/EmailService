package com.gion.cms.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gion.cms.controller.UserController;
import com.gion.cms.entity.TUser;
import com.gion.cms.entity.TUserTransaction;
import com.gion.cms.mapper.TUserMapper;
import com.gion.cms.mapper.TUserTransactionMapper;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	private TUserMapper userMapper;
	
	@Resource
	private TUserTransactionMapper tranMapper;
	
	@Override
	public TUser getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public TUser getUserByPhone(String phone) {
		return userMapper.selectByPhone(phone);
	}

	@Override
	public int insertUser(TUser user) {
		return userMapper.insert(user);
	}

	@Override
	public List<TUser> getAll() {
		return userMapper.selectAll();
	}

	@Override
	public List<TUser> getAllWithPoint() {
		return userMapper.selectAllWIthPoint();
	}
	
	@Override
	public TUser getUserWithPointById(int id) {
		return userMapper.selectUserWIthPointById(id);
	}
	
	@Override
	public List<TUser> getAllTeamMembersByUserId(int userId) {
		return userMapper.getAllTeamMembersByUserId(userId);
	}
	
	@Override
	public List<TUser> getAllParentsByUserId(int userId) {
		return userMapper.getAllParentsByUserId(userId);
	}

	@Override
	public void softDelete(TUser user) {
		userMapper.softDelete(user);
	}

	@Override
	public void insert(TUser user) {
		userMapper.insert(user);
	}

	@Override
	public void update(TUser user) {
		userMapper.updateByPrimaryKey(user);
	}
	
	@Override
	public void updateParentPoints(TUser user) {
		String path = user.getPath();
		String[] userIds = path.split("/");
		if(userIds.length >= 2) {
			int parentId = Integer.valueOf(userIds[userIds.length - 2]);
			TUser parent = new TUser();
			parent.setId(parentId);
			BigDecimal parentRate = BigDecimal.valueOf(0.1);
			parent.setPoint(user.getPoint().multiply(parentRate));
			
			userMapper.addPoints(parent);
			
			TUserTransaction parentTrans = new TUserTransaction();
			parentTrans.setType(2);
			parentTrans.setPoint(user.getPoint().multiply(parentRate));
			parentTrans.setUser(parent);
			parentTrans.setComment(user.getPhone() + " spending");
			parentTrans.setCreateTime(user.getCreateTime());
			parentTrans.setUpdateTime(user.getUpdateTime());
			tranMapper.insert(parentTrans);
			
			if(userIds.length > 2) {
				int grandParentId = Integer.valueOf(userIds[userIds.length - 3]);
				TUser grandParent = new TUser();
				grandParent.setId(grandParentId);
				BigDecimal grandParentRate = BigDecimal.valueOf(0.05);
				grandParent.setPoint(user.getPoint().multiply(grandParentRate));
				
				userMapper.addPoints(grandParent);
				
				TUserTransaction grandParentTrans = new TUserTransaction();
				grandParentTrans.setType(2);
				grandParentTrans.setPoint(user.getPoint().multiply(grandParentRate));
				grandParentTrans.setUser(grandParent);
				grandParentTrans.setComment(user.getPhone() + " spending");
				grandParentTrans.setCreateTime(user.getCreateTime());
				grandParentTrans.setUpdateTime(user.getUpdateTime());
				tranMapper.insert(grandParentTrans);
			}
		}
	}

	@Override
	public TUser getUserWithPointByPhone(String phone) {
		return userMapper.selectUserWIthPointByPhone(phone);
	}

	@Override
	public TUser userLogin(TUser user) {
		
		TUser loginUser = userMapper.userLogin(user);
		return loginUser;
	}

	@Override
	public void updatePassword(TUser user) {
		userMapper.updatePassword(user);
	}
	
	@Override
	public void updatePath(TUser user) {
		userMapper.updatePath(user);
	}

	@Override
	public int addPoints(TUser user) {
		return userMapper.addPoints(user);
	}
}
