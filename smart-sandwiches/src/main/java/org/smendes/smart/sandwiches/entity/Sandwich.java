package org.smendes.smart.sandwiches.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Sandwich.
 * @author mendes
 *
 */
@Entity
public class Sandwich {

	private @Id @GeneratedValue Long id;
	private String name;	

	@OneToMany(mappedBy = "sandwich", fetch = FetchType.LAZY)
	private List<SandwichTopping> toppings = new ArrayList<>();	
	
	private Double value = new Double(0);
	
	public Sandwich() {
		super();
	}

	public Sandwich(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Sandwich [id=" + id + ", name=" + name + ", toppings=" + toppings + ", fullValue=" + getFullValue() + ", value=" + value + "]";
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

	public Double getFullValue() {
		
		double value = 0;
		for (SandwichTopping topping : toppings) {
			value += topping.getIngredient().getValue() * topping.getQtt();
		}
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