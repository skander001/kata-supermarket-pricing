package fr.kata.supermarket.pricing.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;

import fr.kata.supermarket.pricing.service.Basket;

public class QuantityForFreeQuantityDiscount implements Discount {
	
	private Product product;
	private int quantity;
	private int freeQuantity;
	
	public QuantityForFreeQuantityDiscount(Product product, int quantity, int freeQuantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.freeQuantity = freeQuantity;
	}


	@Override
	public BigDecimal calculateTotalDiscount(Basket basket) {
		long nbItems = basket.getNbItemsByProduct(product);
		return nbItems != 0
				? product.getPrice().multiply(quantity - freeQuantity).multiply(new BigDecimal(nbItems / quantity))
				: BigDecimal.ZERO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		final QuantityForFreeQuantityDiscount other = (QuantityForFreeQuantityDiscount) obj;
		return ObjectUtils.equals(product, other.product);
	}
	
	

}
