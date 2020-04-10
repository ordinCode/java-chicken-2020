package domain;

import java.util.List;

public class Price {
	private static final double DISCOUNT_RATE_OF_CASH = 0.95;
	private static final int CASH_NUMBER = 2;

	private final double price;

	public Price(final List<Order> tableOrders, final int formOfPayment) {
		this.price = calculatePrice(tableOrders, formOfPayment);
	}

	private double calculatePrice(final List<Order> tableOrders, final int formOfPayment) {
		double totalPrice = tableOrders.stream()
				.mapToDouble(Order::getPrice)
				.sum();
		long chickenCount = countChicken(tableOrders);
		totalPrice = totalPrice - (int) (chickenCount / 10) * 10000;

		if (formOfPayment == CASH_NUMBER) {
			return totalPrice * DISCOUNT_RATE_OF_CASH;
		}
		return totalPrice;
	}

	public int countChicken(final List<Order> tableOrders) {
		return tableOrders.stream()
				.filter(order -> order.getCategory() == Category.CHICKEN)
				.mapToInt(Order::getCount)
				.sum();
	}

	public double getPrice() {
		return price;
	}
}
