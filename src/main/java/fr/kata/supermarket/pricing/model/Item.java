package fr.kata.supermarket.pricing.model;

import org.apache.commons.lang3.ObjectUtils;

public class Item {

	private Product product;
	private long quantity;
	private Weight unit;

	public Item(Product product, long quantity, Weight unit) {
		this.product = product;
		this.quantity = quantity;
		this.unit = ObjectUtils.defaultIfNull(unit, Weight.NO_UNIT);
	}
	
	public Product getProduct() {
		return product;
	}

	public long getQuantity() {
		return quantity;
	}

	public Weight getUnit() {
		return unit;
	}

	public boolean isSameProduct(Product otherProduct) {
		if (product == null)
			return false;
		return product.equals(otherProduct);
	}
	
}
