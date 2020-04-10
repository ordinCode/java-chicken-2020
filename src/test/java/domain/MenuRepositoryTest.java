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

	@DisplayName("메뉴번호로 메뉴가져오기 - 없는 메뉴 번호")
	@Test
	void findByMenuNumberWithError() {
		int number = 10;

		assertThatThrownBy(() -> MenuRepository.findByMenuNumber(number))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("없는 메뉴입니다");
	}


}
