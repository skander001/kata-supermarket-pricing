package fr.kata.supermarket.pricing.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import fr.kata.supermarket.pricing.model.Discount;
import fr.kata.supermarket.pricing.model.Item;
import fr.kata.supermarket.pricing.model.Weight;

public class Checkout {
	
	private Set<Discount> discounts = new HashSet<>();
	
	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}
	
	public BigDecimal calculateTotal(Basket basket) {
		BigDecimal totalPrice = basket.getItems().stream().map(item -> calculateTotalItemPrice(item))
				.reduce(BigDecimal.ZERO,
				BigDecimal::add);
		BigDecimal totalDiscount = discounts.stream().map(discount -> discount.calculateTotalDiscount(basket)).reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalPrice.subtract(totalDiscount).setScale(2, RoundingMode.FLOOR);
	}

	private BigDecimal calculateTotalItemPrice(Item item) {
		double quantity = getConvertorQuantity(item.getQuantity(), item.getUnit(),
				item.getProduct().getPrice().getUnit());
		return item.getProduct().getPrice().multiply(quantity);
	}

	private double getConvertorQuantity(long quantity, Weight itemUnit, Weight productUnit) {
		if (productUnit.equals(itemUnit)) {
			return quantity;
		}
		if (Weight.NO_UNIT.equals(productUnit) && !productUnit.equals(itemUnit)) {
			throw new IllegalArgumentException(String.format("The item's Weight %s is not valid ", itemUnit.name()));
		}
		switch (productUnit) {
		case POUND:
			return quantity * 16;
		case OUNCE:
			return (double) quantity / 16;
		default:
			throw new IllegalArgumentException(
					String.format("The product's Weight %s is not valid ", productUnit.name()));
		}
	}

}
