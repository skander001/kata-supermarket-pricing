package fr.kata.supermarket.pricing.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import fr.kata.supermarket.pricing.model.Item;
import fr.kata.supermarket.pricing.model.Price;
import fr.kata.supermarket.pricing.model.Product;
import fr.kata.supermarket.pricing.model.QuantityForFreeQuantityDiscount;
import fr.kata.supermarket.pricing.model.QuantityForPriceDiscount;
import fr.kata.supermarket.pricing.model.Weight;

public class CheckoutTest {

	@Test
	public void calculateTotalForFourItemsWithDiscountThreeforOneDollarReturnsValue() {
		Product product = new Product("121212", new Price(new BigDecimal(1), Weight.NO_UNIT));
		Item item = new Item(product, 4, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		Price price = new Price(new BigDecimal(1), Weight.NO_UNIT);
		QuantityForPriceDiscount discount = new QuantityForPriceDiscount(product, 3, price);
		Checkout checkout = new Checkout();
		checkout.addDiscount(discount);
		BigDecimal total = checkout.calculateTotal(basket);
		BigDecimal expected = new BigDecimal(1).setScale(2, RoundingMode.FLOOR);
		assertEquals("three for a dollar ,so what’s the price if I buy 4", expected, total);
		
	}

	@Test
	public void calculateTotalFourOuncesWithUnitPoundWithoutDiscountsReturnsValue() {
		Product product = new Product("58555", new Price(new BigDecimal(1.99), Weight.POUND));
		Item item = new Item(product, 4, Weight.OUNCE);
		Basket basket = new Basket();
		basket.addItem(item);
		Checkout checkout = new Checkout();
		BigDecimal total = checkout.calculateTotal(basket);
		BigDecimal expected = new BigDecimal(127.36).setScale(2, RoundingMode.FLOOR);
		assertEquals("$1.99/pound ,so what does 4 ounces cost?", expected, total);
	}

	@Test
	public void calculateTotalFourPoundsWithUnitOunceWithoutDiscountsReturnsValue() {
		Product product = new Product("9588414", new Price(new BigDecimal(1.99), Weight.OUNCE));
		Item item = new Item(product, 4, Weight.POUND);
		Basket basket = new Basket();
		basket.addItem(item);
		Checkout checkout = new Checkout();
		BigDecimal total = checkout.calculateTotal(basket);
		BigDecimal expected = new BigDecimal(0.496).setScale(2, RoundingMode.FLOOR);
		assertEquals("$1.99/ounce ,so what does 4 pounds cost?", expected, total);
	}

	@Test
	public void calculateTotalForFourItemsWithDiscountBuyTwoGetOneFreeReturnsValue() {
		Product product = new Product("858887447", new Price(new BigDecimal(1), Weight.NO_UNIT));
		Item item = new Item(product, 3, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		QuantityForFreeQuantityDiscount discount = new QuantityForFreeQuantityDiscount(product, 2, 1);
		Checkout checkout = new Checkout();
		checkout.addDiscount(discount);
		BigDecimal total = checkout.calculateTotal(basket);
		BigDecimal expected = new BigDecimal(2).setScale(2, RoundingMode.FLOOR);
		assertEquals("buy two, get one free (so does the third item have a price?)", expected, total);

	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateTotalWhenItemUnitIsPoundAndProductUnitIsNoUnitWithoutDiscountsThrowsExcpetion() {
		Product product = new Product("85845454", new Price(new BigDecimal(1.99), Weight.NO_UNIT));
		Item item = new Item(product, 2, Weight.POUND);
		Basket basket = new Basket();
		basket.addItem(item);
		Checkout checkout = new Checkout();
		checkout.calculateTotal(basket);
	}

}
