package org.smendes.smart.sandwiches.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Ingredient.
 * @author mendes
 *
 */
@Entity
public class Ingredient {

	private @Id @GeneratedValue Long id;
	private String name;	
	private Double value;

	@OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
	private List<SandwichTopping> toppings;	
	
	public Ingredient() {
		super();
	}

	public Ingredient(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<SandwichTopping> getToppings() {
		return toppings;
	}

	public void setToppings(List<SandwichTopping> toppings) {
		this.toppings = toppings;
	}

}