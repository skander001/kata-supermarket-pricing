package fr.kata.supermarket.pricing.model;

import java.math.BigDecimal;

import fr.kata.supermarket.pricing.service.Basket;

public interface Discount {

	public BigDecimal calculateTotalDiscount(Basket basket);
}
