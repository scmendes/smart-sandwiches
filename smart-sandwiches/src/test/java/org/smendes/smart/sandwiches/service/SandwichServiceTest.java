package org.smendes.smart.sandwiches.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smendes.smart.sandwiches.entity.Ingredient;
import org.smendes.smart.sandwiches.entity.IngredientType;
import org.smendes.smart.sandwiches.repository.IngredientRepository;
import org.smendes.smart.sandwiches.to.SandwichInputTO;
import org.smendes.smart.sandwiches.to.SandwichOutputTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SandwichServiceTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private SandwichService sandwichService;
    
    @Test
    public void whenXBurguer() {
    	
    	Ingredient i1 = ingredientRepository.findByName(IngredientType.HAMBURGUER.getName());
    	Ingredient i2 = ingredientRepository.findByName(IngredientType.CHEESE.getName());
    	
    	Double sumValue = i1.getValue() + i1.getValue();
    	
    	SandwichInputTO to1 = new SandwichInputTO();
    	to1.setIngredientId(i1.getId());
    	to1.setQtt(1);
    	SandwichInputTO to2 = new SandwichInputTO();
    	to2.setIngredientId(i2.getId());
    	to2.setQtt(1);
    	
    	List<SandwichInputTO> items = new ArrayList<>();
    	items.add(to1);
    	items.add(to2);
    	
        // when
    	SandwichOutputTO sandwich  = sandwichService.calculateValue(items);
    	System.out.println("------------------ whenXBurguer=" + sandwich.getValue());
    	
        // then
        assertThat(sandwich.getValue()).isEqualTo(sumValue);
    }	 
    
    @Test
    public void whenIsLight() {
    	
    	Ingredient i1 = ingredientRepository.findByName(IngredientType.HAMBURGUER.getName());
    	Ingredient i2 = ingredientRepository.findByName(IngredientType.CHEESE.getName());
    	Ingredient i3 = ingredientRepository.findByName(IngredientType.LETTUCE.getName());
    	
    	Double sumValue = i1.getValue() + i1.getValue() + i3.getValue();
    	
    	SandwichInputTO to1 = new SandwichInputTO();
    	to1.setIngredientId(i1.getId());
    	to1.setQtt(1);
    	SandwichInputTO to2 = new SandwichInputTO();
    	to2.setIngredientId(i2.getId());
    	to2.setQtt(1);
    	SandwichInputTO to3 = new SandwichInputTO();
    	to3.setIngredientId(i3.getId());
    	to3.setQtt(1);
    	
    	List<SandwichInputTO> items = new ArrayList<>();
    	items.add(to1);
    	items.add(to2);
    	items.add(to3);
    	
        // when
    	SandwichOutputTO sandwich = sandwichService.calculateValue(items);
    	System.out.println("------------------ whenIsLight=" + sandwich.getValue());
    	
        // then
        assertThat(sandwich.getValue()).isNotEqualTo(sumValue);
    }	 
    
    @Test
    public void whenSixBurguer() {
    	
    	Ingredient i1 = ingredientRepository.findByName(IngredientType.HAMBURGUER.getName());
    	
    	Double expectedValue = new Double(12);
    	
    	SandwichInputTO to1 = new SandwichInputTO();
    	to1.setIngredientId(i1.getId());
    	to1.setQtt(6);
    	
    	List<SandwichInputTO> items = new ArrayList<>();
    	items.add(to1);
    	
        // when
    	SandwichOutputTO sandwich = sandwichService.calculateValue(items);
    	System.out.println("------------------ whenSixBurguer=" + sandwich.getValue());
    	
        // then
        assertThat(sandwich.getValue()).isEqualTo(expectedValue);
    }	 

    @Test
    public void whenFourCheese() {
    	
    	Ingredient i1 = ingredientRepository.findByName(IngredientType.CHEESE.getName());
    	
    	Double expectedValue = new Double(4.50);
    	
    	SandwichInputTO to1 = new SandwichInputTO();
    	to1.setIngredientId(i1.getId());
    	to1.setQtt(4);
    	
    	List<SandwichInputTO> items = new ArrayList<>();
    	items.add(to1);
    	
        // when
    	SandwichOutputTO sandwich = sandwichService.calculateValue(items);
    	System.out.println("------------------ whenFourCheese=" + sandwich.getValue());
    	
        // then
        assertThat(sandwich.getValue()).isEqualTo(expectedValue);
    }	 
    
}
