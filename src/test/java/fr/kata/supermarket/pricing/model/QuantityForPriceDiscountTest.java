package fr.kata.supermarket.pricing.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fr.kata.supermarket.pricing.service.Basket;

public class QuantityForPriceDiscountTest {

	@Test
	public void calculateTotalDiscountThreeForOneDollarWithFourItemsReturnsValue() {
		Product product = new Product("121212", new Price(new BigDecimal(1), Weight.NO_UNIT));
		Item item = new Item(product, 4, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		Price price = new Price(new BigDecimal(1), Weight.NO_UNIT);
		QuantityForPriceDiscount discount = new QuantityForPriceDiscount(product, 3, price);
		BigDecimal totalDiscount = discount.calculateTotalDiscount(basket);
		assertEquals(new BigDecimal(3), totalDiscount);
	}

	@Test
	public void calculateTotalDiscountThreeForOneDollarWithZeroItemsReturnsZero() {
		Product product = new Product("121212", new Price(new BigDecimal(1), Weight.NO_UNIT));
		Item item = new Item(product, 0, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		Price price = new Price(new BigDecimal(1), Weight.NO_UNIT);
		QuantityForPriceDiscount discount = new QuantityForPriceDiscount(product, 3, price);
		BigDecimal totalDiscount = discount.calculateTotalDiscount(basket);
		assertEquals(BigDecimal.ZERO, totalDiscount);
	}
}
