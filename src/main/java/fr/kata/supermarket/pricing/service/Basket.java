package fr.kata.supermarket.pricing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;

import fr.kata.supermarket.pricing.model.Item;
import fr.kata.supermarket.pricing.model.Product;

public class Basket {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	public long getNbItemsByProduct(Product product) {
		OptionalLong nbItems = items.stream().filter(item -> item.isSameProduct(product))
				.mapToLong(item -> item.getQuantity()).reduce(Long::sum);
		if (nbItems.isPresent()) {
			return nbItems.getAsLong();
		}
		return 0;
	}
}
