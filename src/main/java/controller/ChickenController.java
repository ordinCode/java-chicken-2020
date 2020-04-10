package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Orders;
import domain.Price;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {
	private static final int FUNCTION_NUMBER_REGISTER_ORDER = 1;
	private static final int FUNCTION_ORDER_PAY = 2;
	private static final int FUNCTION_NUMBER_EXIT = 3;

	final static List<Menu> menus = MenuRepository.menus();

	public static void run() {
		final List<Table> tables = TableRepository.tables();
		Orders orders = new Orders();

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

	private static void registerOrder(Orders orders, final List<Table> tables) {
		OutputView.printTables(tables, orders);

		int tableNumber = InputView.inputTableNumber();
		final Table table = TableRepository.findByTableNumber(tableNumber);

		OutputView.printMenus(menus);
		int menuNumber = InputView.inputMenu();
		Menu menu = MenuRepository.findByMenuNumber(menuNumber);
		final int menuCount = InputView.inputCount();

		orders.add(new Order(table, menu, menuCount));
	}

	private static void pay(final Orders Orders, final List<Table> tables) {
		OutputView.printTables(tables, Orders);
		int tableNumber = InputView.inputTableNumberWhenPay();

		List<Order> OrdersOfTable = Orders.filterToTableNumber(tableNumber);
		OutputView.printOrderList(OrdersOfTable);

		int formOfPayment = InputView.inputFormOfPayment(tableNumber);

		Price price = new Price(OrdersOfTable, formOfPayment);
		OutputView.printFinalPrice(price.getPrice());

		Orders.remove(tableNumber);
	}

	public static boolean isNotExit(final int userInput) {
		return FUNCTION_NUMBER_EXIT != userInput;
	}
}
