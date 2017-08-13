package org.smendes.smart.sandwiches.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.smendes.smart.sandwiches.entity.Ingredient;
import org.smendes.smart.sandwiches.entity.IngredientType;
import org.smendes.smart.sandwiches.entity.Sandwich;
import org.smendes.smart.sandwiches.entity.SandwichTopping;
import org.smendes.smart.sandwiches.repository.IngredientRepository;
import org.smendes.smart.sandwiches.to.SandwichInputTO;
import org.smendes.smart.sandwiches.to.SandwichOutputTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servico responsavel por tratar as regras de negocio.
 * @author mendes
 *
 */
@Service
public class SandwichService {
	
	private static final String NAME_CLASS = SandwichService.class.getName();
	private static final Logger LOGGER = Logger.getLogger(NAME_CLASS);
	
	@Autowired
	private IngredientRepository ingredientRepository;

	/**
	 * Calcular o preco do sanduiche com base na composicao.
	 * @param sandwichTO.
	 * @return Preco
	 */
	public SandwichOutputTO calculateValue(final List<SandwichInputTO> items) {
		
		SandwichOutputTO sandwich = new SandwichOutputTO();
		List<SandwichTopping> toppings = new ArrayList<>(); 
		
		for (SandwichInputTO item : items) {
			Ingredient ingredient = ingredientRepository.findOne(item.getIngredientId());
			if (ingredient == null) {
				continue; // skip when not found
			}
			
			SandwichTopping topping = new SandwichTopping();
			topping.setIngredient(ingredient);
			topping.setQtt(item.getQtt());
			
			toppings.add(topping);
			sandwich.getItems().put(ingredient.getName(), item.getQtt());
		}
		
		sandwich.setValue(sum(toppings));
		
		return sandwich;
	}
	
	private Double sum(final List<SandwichTopping> toppings) {
		Double value = new Double(0);
		List<Ingredient> ingredients = new ArrayList<>();
		
		for (SandwichTopping topping : toppings) {
			ingredients.add(topping.getIngredient());
			
			if (topping.getIngredient().getName().equals(IngredientType.HAMBURGUER.getName())) {
				value += burguerRule(topping);
			} else if (topping.getIngredient().getName().equals(IngredientType.CHEESE.getName())) {
				value += cheeseRule(topping);
			} else {
				value += topping.getIngredient().getValue() * topping.getQtt(); 
			}
		}
		
		boolean isLight = isLightRule(ingredients);
		if (isLight) {
			value = value - (value/10);
		}
			
		return value;
	}
	
	private boolean isLightRule(List<Ingredient> ingredients) {
		boolean isLight = false;

		// filtrar alface
		List<Ingredient> filter1 = ingredients.stream()
                .filter((i) -> IngredientType.LETTUCE.getName().equals(i.getName()))
                		.collect(Collectors.toList());		
		if (filter1 == null || filter1.isEmpty()) {
	        // nao tem alface
			LOGGER.info("checkIsLight=" + isLight);
			return isLight;
		}
		
		// filtrar bacon
		List<Ingredient> filter2 = ingredients.stream()
                .filter((i) -> IngredientType.BACON.getName().equals(i.getName()))
                		.collect(Collectors.toList());		
		if (filter2 == null || filter2.isEmpty()) {
	        // nao tem bacon
			isLight = true;
		}
		
		LOGGER.info("checkIsLight=" + isLight);
		return isLight;
	}

	
	private Double burguerRule(SandwichTopping topping) {
		Double value = new Double(0);

		int size = topping.getQtt();
		int discountFor = size / 3;
		double discount = 0;
		
		if (discountFor > 0) {
			value = (discountFor * 2) * topping.getIngredient().getValue();
			int mod = size % 3;
			if ( mod > 0) {
				value += mod * topping.getIngredient().getValue();
			}
		} else {
			value = size * topping.getIngredient().getValue();
		}
		
		LOGGER.info("burguerRule=" + value);
		return value;
	}

	private Double cheeseRule(SandwichTopping topping) {
		Double value = new Double(0);

		int size = topping.getQtt();
		int discountFor = size / 4;
		double discount = 0;
		
		if (discountFor > 0) {
			value = (discountFor * 3) * topping.getIngredient().getValue();
			int mod = size % 4;
			if ( mod > 0) {
				value += mod * topping.getIngredient().getValue();
			}
		} else {
			value = size * topping.getIngredient().getValue();
		}
		
		LOGGER.info("cheeseRule=" + value);
		return value;
	}
	
}
