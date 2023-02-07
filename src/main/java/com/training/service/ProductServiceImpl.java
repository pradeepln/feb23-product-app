package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.dal.ProductDAO;

import com.training.domain.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	ProductDAO dao; // = new ProductDAOInMemImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int addProduct(Product toBeAdded) {
		//check to see if caller has begun, else tx.begin
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			Product added = dao.save(toBeAdded);
			//added.setQoh(555);
			return added.getId();
		}else {
			throw new IllegalArgumentException("Product Value must be GTEQ 10k");
		}
		//if I began, then tx.commit
	}
	
	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
//		existing.setPrice(123f);
		
		if(existing.getPrice() * existing.getQoh() < 100000) {
			dao.deleteById(id);
		}else {
			throw new IllegalStateException("Product worth more than 100k, can't just be deleted!");
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	
	
}
