package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TableTest {
	@DisplayName("테이블 번호가 맞는지 확인 - true")
	@Test
	void isMatchNumber1() {
		int number = 5;
		Table table = new Table(5);

		assertThat(table.isMatchNumber(number)).isTrue();
	}

	@DisplayName("테이블 번호가 맞는지 확인 - false")
	@Test
	void isMatchNumber2() {
		int number = 4;
		Table table = new Table(5);

		assertThat(table.isMatchNumber(number)).isFalse();
	}
}
