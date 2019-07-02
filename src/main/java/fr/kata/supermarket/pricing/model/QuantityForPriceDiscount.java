package fr.kata.supermarket.pricing.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;

import fr.kata.supermarket.pricing.service.Basket;

public class QuantityForPriceDiscount implements Discount {
	private Product product;
	private int quantity;
	private Price price;

	public QuantityForPriceDiscount(Product product, int quantity, Price price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public BigDecimal calculateTotalDiscount(Basket basket) {
		long nbItems = basket.getNbItemsByProduct(product);
		return nbItems != 0 ? product.getPrice().multiply(nbItems).subtract(price.multiply(nbItems / quantity))
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
		final QuantityForPriceDiscount other = (QuantityForPriceDiscount) obj;
		return ObjectUtils.equals(product, other.product);
	}

}
