package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

public class OutputView {
	private static final String TABLE_LIST_HEAD = "## 테이블 목록";
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String MESSAGE_BILL_ITEM = "메뉴   수량   금액";
	private static final String STRING_FORMAT_FINAL_PRICE = "## 최종 결제 금액 : %.1f";
	private static final String SEPARATE_LINE = "\n";

	public static void printTables(final List<Table> tables) {
		System.out.println(TABLE_LIST_HEAD);
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printOrderList(final List<Order> tableOrders) {
		System.out.println(MESSAGE_BILL_ITEM);
		System.out.println(OrderList(tableOrders));
	}

	private static String OrderList(final List<Order> tableOrders) {
		StringBuilder builder = new StringBuilder();
		for (Order tableOrder : tableOrders) {
			builder.append(tableOrder.toString() + SEPARATE_LINE);
		}
		return builder.toString();
	}

	public static void printFinalPrice(final double price) {
		System.out.println(String.format(STRING_FORMAT_FINAL_PRICE, price));
	}
}
