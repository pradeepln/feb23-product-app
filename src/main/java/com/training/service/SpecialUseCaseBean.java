package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.training.dal.ProductDAO;
import com.training.dal.ProductDAOInMemImpl;

import jakarta.annotation.PostConstruct;

@Service
public class SpecialUseCaseBean {
	
	@Autowired
	@Qualifier("productDAOInMemImpl")
	ProductDAO dao;
	
	@PostConstruct
	public void logTypeOfDAO() {
		System.out.println("<<<<<<<<< type of dao "+dao.getClass().getTypeName()+" >>>>>>>>>");
	}

}
