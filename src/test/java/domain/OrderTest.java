package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderTest {
	@DisplayName("테이블번호비교")
	@Test
	void isMatchTableNumber() {
		int tableNumber = 1;

		Order order = new Order(1, 1, 2);

		assertThat(order.isMatchTableNumber(tableNumber)).isTrue();
	}

	@Test
	void toStringTest() {
		Order order = new Order(1, 1, 2);
		assertThat(order.toString()).isEqualTo(
				"후라이드 2 16000"
		);
	}
}
