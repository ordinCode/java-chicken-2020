package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MenuRepositoryTest {
	@DisplayName("메뉴번호로 메뉴가져오기")
	@Test
	void findByMenuNumber() {
		int number = 4;
		String menuName = "통구이";

		assertThat(MenuRepository.findByMenuNumber(number).getName())
				.isEqualTo(menuName);
	}
}
