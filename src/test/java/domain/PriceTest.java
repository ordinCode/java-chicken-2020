package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PriceTest {
	List<Order> orders;

	@BeforeEach
	void setUp() {
		orders = new ArrayList<>();
	}

	@DisplayName("결제금액계산 - 하나의 주문, 신용카드")
	@Test
	void calculatePrice() {
		orders.add(new Order(1, 1, 2));
		int formOfPayment = 1;

		Price price = new Price(orders, formOfPayment);

		assertThat(price.getPrice()).isEqualTo(32000);
	}

	@DisplayName("결제금액계산 - 두개 이상의 주문, 신용카드")
	@Test
	void calculatePrice2() {
		orders.add(new Order(1, 1, 2));
		orders.add(new Order(1, 21, 2));
		int formOfPayment = 1;

		Price price = new Price(orders, formOfPayment);

		assertThat(price.getPrice()).isEqualTo(34000);
	}

	@DisplayName("결제금액계산 - 현금")
	@Test
	void calculatePrice3() {
		orders.add(new Order(1, 1, 2));
		orders.add(new Order(1, 21, 2));
		int formOfPayment = 2;

		Price price = new Price(orders, formOfPayment);

		assertThat(price.getPrice()).isEqualTo(34000 * 0.95);
	}

	@DisplayName("주문중 치킨의 갯수 계산")
	@Test
	void countChicken() {
		orders.add(new Order(1, 1, 10));
		orders.add(new Order(1, 21, 2));

		Price price = new Price(orders, 1);

		assertThat(price.countChicken(orders)).isEqualTo(10);

	}

	@DisplayName("결제금액계산 - 10개 치킨 카드")
	@Test
	void calculatePrice4() {
		orders.add(new Order(1, 1, 10));
		orders.add(new Order(1, 21, 2));
		int formOfPayment = 1;

		Price price = new Price(orders, formOfPayment);

		assertThat(price.getPrice()).isEqualTo(150000 + 2000);
	}

	@DisplayName("결제금액계산 - 20개 치킨 현금")
	@Test
	void calculatePrice5() {
		orders.add(new Order(1, 1, 20));
		orders.add(new Order(1, 21, 10));
		int formOfPayment = 2;

		Price price = new Price(orders, formOfPayment);

		assertThat(price.getPrice()).isEqualTo((300000 + 10000) * 0.95);
	}
}
