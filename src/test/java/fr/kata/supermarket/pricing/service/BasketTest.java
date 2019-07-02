package fr.kata.supermarket.pricing.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fr.kata.supermarket.pricing.model.Item;
import fr.kata.supermarket.pricing.model.Price;
import fr.kata.supermarket.pricing.model.Product;
import fr.kata.supermarket.pricing.model.Weight;

public class BasketTest {

	@Test
	public void addingItemToBasket() {
		Product product = new Product("857788", new Price(new BigDecimal(12), Weight.NO_UNIT));
		Item item = new Item(product, 2, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		assertEquals(1, basket.getItems().size());
	}

	@Test
	public void getNbItemsByProductWhenProductNotExistInBasketReturnsZero() {
		Product firstProduct = new Product("857788", new Price(new BigDecimal(12), Weight.NO_UNIT));
		Item item = new Item(firstProduct, 2, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		Product secondProduct = new Product("012548", new Price(new BigDecimal(5), Weight.NO_UNIT));
		long nbItemsProduct = basket.getNbItemsByProduct(secondProduct);
		assertEquals(0, nbItemsProduct);
	}

	@Test
	public void getNbItemsByProductWhenProductExistInBasketReturnsValue() {
		Product product = new Product("85555222", new Price(new BigDecimal(12), Weight.NO_UNIT));
		Item item = new Item(product, 2, Weight.NO_UNIT);
		Basket basket = new Basket();
		basket.addItem(item);
		long nbItemsProduct = basket.getNbItemsByProduct(product);
		assertEquals(2, nbItemsProduct);
	}
}