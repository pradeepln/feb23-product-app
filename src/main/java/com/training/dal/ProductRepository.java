package com.training.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	public List<Product> findByName(String s); 
	public List<Product> findByNameLike(String s);
	public List<Product> findByPriceLessThan(float p);
	
	@Query("select p from Product as p where p.qoh>:qParam")
	public List<Product> myComplexQuery(@Param("qParam") int q);
}
