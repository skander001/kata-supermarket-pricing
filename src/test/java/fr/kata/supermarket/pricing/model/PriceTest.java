package fr.kata.supermarket.pricing.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;

public class PriceTest {

	@Test
	public void creatingPriceWithNullValueAndNullWeightCreatesPrice() {
		Price price = new Price(null, null);
		assertNotNull(price);
		assertEquals(new Price(BigDecimal.ZERO, Weight.NO_UNIT), price);
	}

	@Test
	public void multiplyPriceByValueReturnsMultipliedValue() {
		Price price = new Price(new BigDecimal(2.5), Weight.NO_UNIT);
		BigDecimal result = price.multiply(3);
		assertEquals(new BigDecimal(7.5), result);
	}

}
