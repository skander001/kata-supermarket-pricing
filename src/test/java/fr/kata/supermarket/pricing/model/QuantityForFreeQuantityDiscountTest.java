package fr.kata.supermarket.pricing.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fr.kata.supermarket.pricing.service.Basket;

public class QuantityForFreeQuantityDiscountTest {

	@Test
	public void calculateTotalDiscountTwoForOneFreeWithThreeItemsReturnsValue() {
		Product product = new Product("121212", new Price(new BigDecimal(2), Weight.NO_UNIT));
		Item item = new Item(product, 3, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		QuantityForFreeQuantityDiscount discount = new QuantityForFreeQuantityDiscount(product, 2, 1);
		BigDecimal totalDiscount = discount.calculateTotalDiscount(basket);
		assertEquals(new BigDecimal(2), totalDiscount);
	}

	@Test
	public void calculateTotalDiscountTwoForOneFreeWithZeroItemsReturnsZero() {
		Product product = new Product("121212", new Price(new BigDecimal(2), Weight.NO_UNIT));
		Item item = new Item(product, 0, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		QuantityForFreeQuantityDiscount discount = new QuantityForFreeQuantityDiscount(product, 2, 1);
		BigDecimal totalDiscount = discount.calculateTotalDiscount(basket);
		assertEquals(BigDecimal.ZERO, totalDiscount);
	}
}
