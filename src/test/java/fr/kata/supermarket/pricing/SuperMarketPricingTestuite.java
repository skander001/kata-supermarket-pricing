package fr.kata.supermarket.pricing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.kata.supermarket.pricing.model.ItemTest;
import fr.kata.supermarket.pricing.model.PriceTest;
import fr.kata.supermarket.pricing.model.ProductTest;
import fr.kata.supermarket.pricing.model.QuantityForFreeQuantityDiscountTest;
import fr.kata.supermarket.pricing.model.QuantityForPriceDiscountTest;
import fr.kata.supermarket.pricing.service.BasketTest;
import fr.kata.supermarket.pricing.service.CheckoutTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PriceTest.class, ProductTest.class, ItemTest.class, QuantityForFreeQuantityDiscountTest.class,
		QuantityForPriceDiscountTest.class, BasketTest.class, CheckoutTest.class })
public class SuperMarketPricingTestuite {

}
