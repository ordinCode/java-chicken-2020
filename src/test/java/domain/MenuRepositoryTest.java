package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MenuRepositoryTest {
	@Test
	void findByMenuNumber() {
		int number = 4;
		String menuName = "통구이";

		assertThat(MenuRepository.findByMenuNumber(number).getName())
				.isEqualTo(menuName);
	}
}
