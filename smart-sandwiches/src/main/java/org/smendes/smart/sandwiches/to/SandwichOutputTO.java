package org.smendes.smart.sandwiches.to;

import java.util.HashMap;
import java.util.Map;

public class SandwichOutputTO {
	
	private Map<String, Integer> items = new HashMap<String, Integer>();
	private Double value = new Double(0);

	public Map<String, Integer> getItems() {
		return items;
	}
	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
}
