package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final int count;

	public Order(final int tableNumber, final Menu menu, final int count) {
		this.table = TableRepository.findByTableNumber(tableNumber);
		this.menu = menu;
		this.count = count;
	}
}
