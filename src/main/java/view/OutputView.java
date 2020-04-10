package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MESSAGE_BILL_ITEM = "메뉴   수량   금액";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
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

    public static void printOrderList(final List<Order> orders, final int tableNumber) {
        List<Order> tableOrders = orders.stream()
                .filter(order -> order.isMatchTableNumber(tableNumber))
                .collect(Collectors.toList());
        System.out.println(MESSAGE_BILL_ITEM);
        System.out.println(OrderList(tableOrders));
    }

    private static String OrderList(final List<Order> tableOrders) {
        StringBuilder builder = new StringBuilder();
        for (Order tableOrder : tableOrders) {
            builder.append(tableOrder.toString() + "\n");
        }
        return builder.toString();
    }
}
