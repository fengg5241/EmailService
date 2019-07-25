package com.gion.cms.service;

import java.util.List;

import com.gion.cms.entity.TUser;
import com.gion.cms.entity.TUserTransaction;

public interface UserService {

	TUser getUserById(int id);
	
	TUser getUserByPhone(String phone);
	
	int insertUser(TUser user);
	
	List<TUser> getAll();
	
	List<TUser> getAllWithPoint();
	
	TUser getUserWithPointById(int id);
	
	TUser getUserWithPointByPhone(String phone);
	
	List<TUser> getAllTeamMembersByUserId(int userId);
	
	List<TUser> getAllParentsByUserId(int userId);
	
	void softDelete(TUser user);
	
	void insert(TUser user);
	
	void update(TUser user);
	
	void updateParentPoints(TUser user);
	
	TUser userLogin(TUser user);
	
	void updatePassword(TUser user);
	
	void updatePath(TUser user);
	
	int addPoints(TUser user);
}
