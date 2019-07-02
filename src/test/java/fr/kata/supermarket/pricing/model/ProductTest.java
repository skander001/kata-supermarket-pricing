package fr.kata.supermarket.pricing.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductTest {

	@Test
	public void creatingProductWithPriceAndCodeCreatesProduct() {
		Price price = new Price(new BigDecimal(3.25), Weight.NO_UNIT);
		Product product = new Product("0124585965", price);
		assertNotNull(product);
		assertEquals(price, product.getPrice());
	}

}
