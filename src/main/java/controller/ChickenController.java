package controller;

import domain.ChickenFunction;
import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Orders;
import domain.Price;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChickenController {
	private static Map<Integer, ChickenFunction<Orders, List>> functions = new HashMap<>();

	static {
		functions.put(1, (ChickenController::registerOrder));
		functions.put(2, (ChickenController::pay));
		functions.put(3, (ChickenController::exit));
	}

	final static List<Menu> menus = MenuRepository.menus();

	public static void run() {
		final List<Table> tables = TableRepository.tables();
		Orders orders = new Orders();
		while (true) {
			functions.get(InputView.inputAction()).run(orders, tables);
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

	private static void exit(final Orders orders, final List list) {
		OutputView.printExitMessage();
		System.exit(0);
	}
}
