package com.gion.cms.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gion.cms.entity.TUserTransaction;
import com.gion.cms.service.UserTransactionService;

@RestController
@RequestMapping("/transaction")
public class UserTransactionController {
	
	@Autowired
	private UserTransactionService tranService;
	
	@RequestMapping(value = "/getById/{id}", produces = "application/json")
	public TUserTransaction getById(@PathVariable int id) {
		return tranService.getTransactionById(id);
	}
	
	@RequestMapping(value = "/getAll", produces = "application/json")
	public List<TUserTransaction> getAll() {
		return tranService.getAll();
	}
	
	@RequestMapping(value = "/getAllByPhone/{phone}", produces = "application/json")
	public List<TUserTransaction> getAllByPhone(@PathVariable String phone) {
		return tranService.getAllByPhone(phone);
	}
	
//	@RequestMapping(value = "/getPointById/{id}", produces = "application/json")
//	public BigDecimal getPointById(@PathVariable int id) {
//		return tranService.getPointByUserId(id);
//	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody TUserTransaction record) {
		tranService.insert(record);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TUserTransaction record) {
		tranService.update(record);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TUserTransaction record) {
		tranService.delete(record);
	}
}
