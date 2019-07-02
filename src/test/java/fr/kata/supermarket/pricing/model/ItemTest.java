package fr.kata.supermarket.pricing.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTest {

	@Test
	public void creatingItemWithProductAndQuantityAndUnitCreatesItem() {
		Product product = new Product("475145585", new Price(new BigDecimal(2.35), Weight.NO_UNIT));
		Item item = new Item(product, 5, Weight.NO_UNIT);
		assertNotNull(item);
		assertEquals(product, item.getProduct());
		assertEquals(5, item.getQuantity());
		assertEquals(Weight.NO_UNIT, item.getUnit());

	}

	@Test
	public void comparingTwoProductWithEverythingEqualRetunsTrue() {
		Product product1 = new Product("7558447447", new Price(new BigDecimal(7.25), Weight.POUND));
		Item item = new Item(product1, 2, Weight.POUND);
		Product product2 = new Product("7558447447", new Price(new BigDecimal(7.25), Weight.POUND));
		boolean areSame = item.isSameProduct(product2);
		assertEquals(true, areSame);
	}

}
