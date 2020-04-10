package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Price;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChickenController {
	private static final int FUNCTION_NUMBER_REGISTER_ORDER = 1;
	private static final int FUNCTION_ORDER_PAY = 2;
	private static final int FUNCTION_NUMBER_EXIT = 3;

	final static List<Menu> menus = MenuRepository.menus();

	public static void run() {
		final List<Table> tables = TableRepository.tables();
		List<Order> orders = new ArrayList<>();

		int userInput = InputView.inputAction();
		while (isNotExit(userInput)) {
			if (userInput == FUNCTION_NUMBER_REGISTER_ORDER) {
				registerOrder(orders, tables);
			}
			if (userInput == FUNCTION_ORDER_PAY) {
				pay(orders, tables);
			}
			userInput = InputView.inputAction();
		}
	}

	private static void registerOrder(List<Order> orders, final List<Table> tables) {
		OutputView.printTables(tables, orders);

		final Table table = TableRepository.findByTableNumber(InputView.inputTableNumber());

		OutputView.printMenus(menus);
		Menu menu = MenuRepository.findByMenuNumber(InputView.inputMenu());
		final int menuCount = InputView.inputCount();

		orders.add(new Order(table, menu, menuCount));
	}

	private static void pay(final List<Order> totalOrders, final List<Table> tables) {
		OutputView.printTables(tables, totalOrders);
		int tableNumber = InputView.inputTableNumberWhenPay();

		List<Order> OrdersOfTable = totalOrders.stream()
				.filter(order -> order.isMatchTableNumber(tableNumber))
				.collect(Collectors.toList());
		OutputView.printOrderList(OrdersOfTable);

		int formOfPayment = InputView.inputFormOfPayment(tableNumber);

		Price price = new Price(OrdersOfTable, formOfPayment);
		OutputView.printFinalPrice(price.getPrice());

		totalOrders.removeIf(order -> order.isMatchTableNumber(tableNumber));
	}

	public static boolean isNotExit(final int userInput) {
		return FUNCTION_NUMBER_EXIT != userInput;
	}
}
