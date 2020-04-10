package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TableRepositoryTest {
	@Test
	void findByTableNumber() {
		int tableNumber = 1;

		Table table = TableRepository.findByTableNumber(tableNumber);

		assertThat(TableRepository.findByTableNumber(tableNumber));
	}
}
