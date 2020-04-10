package domain;

public class Order {
	private static final String ERROR_MESSAGE_COUNT = "1 ~ 99 사이의 숫자를 입력하세요";
	private static final int MIN_COUNT = 1;
	private static final int MAX_COUNT = 99;

	private final Table table;
	private final Menu menu;
	private final int count;

	public Order(final Table table, final Menu menu, final int count) {
		validate(count);
		this.table = table;
		this.menu = menu;
		this.count = count;
	}

	private void validate(final int count) {
		if (count < MIN_COUNT || count > MAX_COUNT) {
			throw new IllegalArgumentException(ERROR_MESSAGE_COUNT);
		}
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

	public Table getTable() {
		return this.table;
	}

	public boolean isMatchTable(final Table table) {
		return this.table.equals(table);
	}
}
