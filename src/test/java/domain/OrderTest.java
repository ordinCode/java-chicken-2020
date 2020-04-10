package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderTest {
	private Table table1;
	private Menu chicken;

	@BeforeEach
	void setUp() {
		table1 = new Table(1);
		chicken = MenuRepository.findByMenuNumber(1);
	}

	@DisplayName("테이블번호비교")
	@Test
	void isMatchTableNumber() {
		int tableNumber = 1;

		Order order = new Order(table1, chicken, 2);

		assertThat(order.isMatchTableNumber(tableNumber)).isTrue();
	}

	@DisplayName("주문내역 출력 테스트")
	@Test
	void toStringTest() {
		Order order = new Order(table1, chicken, 2);
		assertThat(order.toString()).isEqualTo(
				"후라이드 2 16000"
		);
	}
}
