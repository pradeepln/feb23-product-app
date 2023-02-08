package com.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.dal.ProductRepository;
import com.training.domain.Product;


@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
//		ApplicationContext springContainer = 
				SpringApplication.run(ProductAppApplication.class, args);
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ProductConsoleUI ui2 = springContainer.getBean(ProductConsoleUI.class);
//		System.out.println("Are the two beans , same? "+(ui == ui2));
//		ui.createProductWithUI();
		
//		testRepo(springContainer);
	}

	private static void testRepo(ApplicationContext springContainer) {
		
		ProductRepository repo = springContainer.getBean(ProductRepository.class);
		
//		List<Product> productList = repo.findAll();
//		
//		System.out.println(productList.size()); //10
//		
//		//other app inserted 1 row
//		
//		System.out.println(productList.size()); // 10
//		
//		productList = repo.findAll();
//		
		
//		System.out.println(productList.size()); // 11
		
		Product testData = new Product("testrepo", 1234f, 12);
		
		Product saved = repo.save(testData);
		
		System.out.println("Saved using repo: "+saved.getId());
	}

}
