package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrdersTest {
	private Orders orders;
	private Table table1;
	private Table table2;
	private Menu chicken;

	@BeforeEach
	void setUp() {
		orders = new Orders();
		table1 = new Table(1);
		table2 = new Table(2);
		chicken = MenuRepository.findByMenuNumber(1);
	}

	@Test
	void containsTest() {
		Order order = new Order(table1, chicken, 2);
		orders.add(order);

		assertThat(orders.contains(table1)).isTrue();
		assertThat(orders.contains(table2)).isFalse();
	}

	@Test
	void filterToTableNumber() {
		orders.add(new Order(table1, chicken, 2));
		orders.add(new Order(table1, chicken, 3));
		orders.add(new Order(table2, chicken, 1));

		assertThat(orders.filterToTableNumber(1).size()).isEqualTo(2);

	}
}
