package org.smendes.smart.sandwiches.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Ingredient.
 * @author mendes
 *
 */
@Entity
public class SandwichTopping {

	private @Id @GeneratedValue Long id;
	
	private Integer qtt = 1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SANDWICH_ID")	
	private Sandwich sandwich;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INGREDIENT_ID")	
	private Ingredient ingredient;
	
	public SandwichTopping() {
		super();
	}

	public SandwichTopping(Ingredient ingredient, Integer qtt, Sandwich sandwich) {
		super();
		this.ingredient = ingredient;
		this.qtt = qtt;
		this.sandwich = sandwich;
	}

	@Override
	public String toString() {
		return "SandwichTopping [id=" + id + ", qtt=" + qtt + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}



	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}



	public Integer getQtt() {
		return qtt;
	}



	public void setQtt(Integer qtt) {
		this.qtt = qtt;
	}



	public Sandwich getSandwich() {
		return sandwich;
	}



	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}


}