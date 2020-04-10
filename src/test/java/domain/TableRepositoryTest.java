package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TableRepositoryTest {
	@DisplayName("테이블 번호로 테이블 가져오기")
	@Test
	void findByTableNumber() {
		int tableNumber = 1;
		assertThat(TableRepository.findByTableNumber(tableNumber).isMatchNumber(tableNumber)).isTrue();
	}

	@DisplayName("테이블 번호로 테이블 가져올때 없는 테이블 입력")
	@Test
	void findByTableNumberWithError() {
		int tableNumber = 4;

		assertThatThrownBy(() -> TableRepository.findByTableNumber(tableNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("없는 테이블입니다");
	}

	@DisplayName("테이블 번호로 테이블 가져올때 캐싱 테스트")
	@Test
	void findByTableNumberCash() {
		Table table1 = TableRepository.findByTableNumber(1);
		Table table2 = TableRepository.findByTableNumber(1);

		assertThat(table1 == table2).isTrue();
	}


}
