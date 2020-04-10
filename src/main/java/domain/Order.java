package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final int count;

	public Order(final int tableNumber, final int menuNumber, final int count) {
		this.table = TableRepository.findByTableNumber(tableNumber);
		this.menu = MenuRepository.findByMenuNumber(menuNumber);
		this.count = count;
	}

	public boolean isMatchTableNumber(final int tableNumber) {
		return table.isMatchNumber(tableNumber);
	}

	@Override
	public String toString() {
		return menu.getName() + " " + count + " " + menu.getPrice();
	}
}
