package com.training.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.domain.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Primary
@Transactional
@Repository
public class ProductDAOJpaImpl implements ProductDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public Product save(Product toBeSaved) {
		//check to see if caller has begun, else tx.begin
		//toBeSaved --> new
		em.persist(toBeSaved);
		//toBeSaved --> managed
		return toBeSaved;
		//if I began, then tx.commit
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		Query q = em.createQuery("select p from Product as p");//jpql
		List<Product> all = q.getResultList();
		return all;
	}

	@Override
	public void deleteById(int id) {
		Query q = em.createQuery("delete p from Product p where p.id=:idParam");
		q.setParameter("idParam", id);
		q.executeUpdate();
		//Product p = em.find(Product.class, id);
		// p --> managed
		//em.remove(p);
		// p --> new
	}

}
