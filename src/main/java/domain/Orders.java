package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
	private final List<Order> orders;

	public Orders() {
		this.orders = new ArrayList<>();
	}

	public void add(Order order) {
		orders.add(order);
	}

	public boolean contains(final Table table) {
		return orders.stream()
				.anyMatch(order -> order.isMatchTable(table));
	}

	public List<Order> filterToTableNumber(final int tableNumber) {
		return orders.stream()
				.filter(order -> order.isMatchTableNumber(tableNumber))
				.collect(Collectors.toList());
	}

	public void remove(final int tableNumber) {
		orders.removeIf(order -> order.isMatchTableNumber(tableNumber));
	}
}
