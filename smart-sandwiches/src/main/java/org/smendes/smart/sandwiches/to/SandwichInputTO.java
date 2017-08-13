package org.smendes.smart.sandwiches.to;

public class SandwichInputTO {
	private Long  ingredientId;
	private Integer qtt;
	public Long getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	public Integer getQtt() {
		return qtt;
	}
	public void setQtt(Integer qtt) {
		this.qtt = qtt;
	}
}
