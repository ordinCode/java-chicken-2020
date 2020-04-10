package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final int count;

	public Order(final Table table, final Menu menu, final int count) {
		this.table = table;
		this.menu = menu;
		this.count = count;
	}

	public boolean isMatchTableNumber(final int tableNumber) {
		return table.isMatchNumber(tableNumber);
	}

	@Override
	public String toString() {
		return menu.getName() + " " + count + " " + menu.getPrice();
	}

	public int getPrice() {
		return menu.getPrice() * count;
	}

	public Category getCategory() {
		return menu.getCategory();
	}

	public int getCount() {
		return count;
	}
}
