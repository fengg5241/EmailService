package com.gion.cms.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gion.cms.entity.TUser;
import com.gion.cms.entity.TUserTransaction;
import com.gion.cms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
 

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getById/{id}", produces = "application/json")
	public TUser getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	/*
	 * if no this user, then return null
	 */
	@RequestMapping(value = "/getByPhone/{phone}", produces = "application/json")
	public TUser getUserByPhone(@PathVariable String phone) {
		return userService.getUserByPhone(phone);
	}
	
	@RequestMapping(value = "/getUserWithPointByPhone/{phone}", produces = "application/json")
	public TUser getUserWithPointByPhone(@PathVariable String phone) {
		return userService.getUserWithPointByPhone(phone);
	}
	
	/*
	 * if no this user, then insert then return
	 */
	@RequestMapping(value = "/getByPhoneOrInsert/{phone}", produces = "application/json")
	public TUser getByPhoneOrInsert(@PathVariable String phone) {
		TUser user = userService.getUserByPhone(phone);
		if(user == null) {
			user = new TUser();
			user.setPhone(phone);
			user.setPassword("123456");
			user.setType(1);
			user.setPoint(BigDecimal.ZERO);
			userService.insertUser(user);
		}
		return user;
		
	}
	
	@PostMapping(value = "/getByPhoneOrInsert", produces = "application/json")
	public TUser getByPhoneOrInsert(@RequestBody TUser record) {
		TUser user = userService.getUserByPhone(record.getPhone());
		if(user == null) {
			user = new TUser();
			user.setPhone(record.getPhone());
			user.setName(record.getName());
			user.setPassword("123456");
			user.setType(1);
			user.setPoint(BigDecimal.ZERO);
			userService.insertUser(user);
		}
		return user;
		
	}
	
	@RequestMapping(value = "/getByPhoneOrInsertWithPoint/{phone}", produces = "application/json")
	public TUser getByPhoneOrInsertWithPoint(@PathVariable String phone) {
		TUser user = userService.getUserByPhone(phone);
		if(user == null) {
			user = new TUser();
			user.setPhone(phone);
			user.setType(1);
			user.setPassword("123456");
			user.setPoint(BigDecimal.ZERO);
			userService.insertUser(user);
		}else {
			user = userService.getUserWithPointById(user.getId());
		}
		return user;
	}
	
	@RequestMapping(value = "/getAllWithPoint", produces = "application/json")
	public List<TUser> getAllWithPoint() {
		return userService.getAllWithPoint();
	}
	
	@RequestMapping(value = "/getAllTeamMembersByUserId/{userId}", produces = "application/json")
	public List<TUser> getAllTeamMembersByUserId(@PathVariable int userId) {
		return userService.getAllTeamMembersByUserId(userId);
	}
	
	@RequestMapping(value = "/getAllParentsByUserId/{userId}", produces = "application/json")
	public List<TUser> getAllParentsByUserId(@PathVariable int userId) {
		return userService.getAllParentsByUserId(userId);
	}
	
	@PostMapping("/updateParentPoints")
	public void updateParentPoints(@RequestBody TUser record) {
		userService.updateParentPoints(record);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody TUser record) {
		userService.insert(record);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TUser record) {
		userService.update(record);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TUser user) {
		userService.softDelete(user);
	}
	
	@PostMapping("/login")
	public TUser login(@RequestBody TUser user) {
		log.info("login method");
		return userService.userLogin(user);
	}
	
	@PostMapping("/updatePassword")
	public void updatePassword(@RequestBody TUser record) {
		userService.updatePassword(record);
	}
	
	@PostMapping("/updatePath")
	public void updatePath(@RequestBody TUser record) {
		userService.updatePath(record);
	}
	
	@PostMapping("/addPoints")
	public void addPoints(@RequestBody TUser record) {
		userService.addPoints(record);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "hello";
	}
	
	
	
}
