package fr.kata.supermarket.pricing.model;

import org.apache.commons.lang3.ObjectUtils;

public class Product {
	
	private String code;
	private Price price;

	public Product(String code, Price price) {
		this.code = code;
		this.price = price;
	}
	
	public Price getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		return ObjectUtils.equals(code, other.code);
	}

}
