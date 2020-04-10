package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrdersTest {
	private Orders orders;

	@BeforeEach
	void setUp() {
		orders = new Orders();
	}

	@Test
	void containsTest() {
		Table table1 = new Table(1);
		Table table2 = new Table(2);
		Order order = new Order(table1, MenuRepository.findByMenuNumber(1), 2);
		orders.add(order);

		assertThat(orders.contains(table1)).isTrue();
		assertThat(orders.contains(table2)).isFalse();
	}
}
