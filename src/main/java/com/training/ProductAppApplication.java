package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.dal.ProductRepository;
import com.training.domain.Product;
import com.training.ui.ProductConsoleUI;


@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = 
				SpringApplication.run(ProductAppApplication.class, args);
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ProductConsoleUI ui2 = springContainer.getBean(ProductConsoleUI.class);
//		System.out.println("Are the two beans , same? "+(ui == ui2));
//		ui.createProductWithUI();
		
		testRepo(springContainer);
	}

	private static void testRepo(ApplicationContext springContainer) {
		
		ProductRepository repo = springContainer.getBean(ProductRepository.class);
		
		Product testData = new Product("testrepo", 1234f, 12);
		
		Product saved = repo.save(testData);
		
		System.out.println("Saved using repo: "+saved.getId());
	}

}
