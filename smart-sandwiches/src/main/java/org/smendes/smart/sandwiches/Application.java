package org.smendes.smart.sandwiches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smendes.smart.sandwiches.entity.Ingredient;
import org.smendes.smart.sandwiches.entity.IngredientType;
import org.smendes.smart.sandwiches.entity.Sandwich;
import org.smendes.smart.sandwiches.entity.SandwichTopping;
import org.smendes.smart.sandwiches.repository.IngredientRepository;
import org.smendes.smart.sandwiches.repository.SandwichRepository;
import org.smendes.smart.sandwiches.repository.SandwichToppingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	/** Inicializa a aplicacao Spring boot.
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("Inspect the beans provided:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}


	/**
	 * Inicializa a aplicacao criando alguns registros iniciais.
	 * @param processRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(IngredientRepository ingredientRepository, 
			SandwichToppingRepository toppingRepository,
			SandwichRepository sandwichRepository) {
		return (args) -> {
			
			createInitialData(ingredientRepository, toppingRepository, sandwichRepository);

			log.info("ingredients.findAll():");
			log.info("-------------------------------");
			
			for (Ingredient item : ingredientRepository.findAll()) {
				log.info(item.toString());
			}

			log.info("toppings.findAll():");
			log.info("-------------------------------");
			for (SandwichTopping item : toppingRepository.findAll()) {
				log.info(item.toString());
			}

			log.info("sandwiches.findAll():");
			log.info("-------------------------------");
			for (Sandwich item : sandwichRepository.findAll()) {
				log.info(item.toString());
			}
		};
	}
	
	private void createInitialData(IngredientRepository ingredientRepository, 
			SandwichToppingRepository toppingRepository,
			SandwichRepository sandwichRepository) {

		Ingredient burguer = ingredientRepository.save(new Ingredient(IngredientType.HAMBURGUER.getName(), 3.00));
		Ingredient cheese = ingredientRepository.save(new Ingredient(IngredientType.CHEESE.getName(), 1.50));
		Ingredient bacon = ingredientRepository.save(new Ingredient(IngredientType.BACON.getName(), 2.00));
		Ingredient egg = ingredientRepository.save(new Ingredient(IngredientType.EGG.getName(), 0.80));
		Ingredient lettuce = ingredientRepository.save(new Ingredient(IngredientType.LETTUCE.getName(), 0.40));

		Sandwich xBurguer = sandwichRepository.save(new Sandwich("X-Burger"));
		
		toppingRepository.save(new SandwichTopping(burguer, 1, xBurguer));
		toppingRepository.save(new SandwichTopping(cheese, 1, xBurguer));

	}
	

}
