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

	@DisplayName("수량 0 입력")
	@Test
	void create() {
		assertThatThrownBy(() -> new Order(table1, chicken, 0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1 ~ 99 사이의 숫자를 입력하세요");
	}

	@DisplayName("수량 100 입력")
	@Test
	void create2() {
		assertThatThrownBy(() -> new Order(table1, chicken, 100))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1 ~ 99 사이의 숫자를 입력하세요");
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
