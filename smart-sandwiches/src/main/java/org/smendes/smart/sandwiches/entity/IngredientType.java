package org.smendes.smart.sandwiches.entity;

public enum IngredientType {

	HAMBURGUER("Hambúrguer de carne"),
	CHEESE("Queijo"),
	BACON("Bacon"),
	EGG("Ovo"),
	LETTUCE("Alface");	
	
	private String name;

	private IngredientType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
