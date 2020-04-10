package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ChickenControllerTest {
	@DisplayName("유저가 프로그램 종료외 다른기능을 입력했는지 확인")
	@Test
	void isNotExit1() {
		int userInput = 1;

		assertThat(ChickenController.isNotExit(userInput)).isTrue();
	}

	@DisplayName("유저가 프로그램 종료 기능을 입력했는지 확인")
	@Test
	void isNotExit2() {
		int userInput = 3;

		assertThat(ChickenController.isNotExit(userInput)).isFalse();
	}
}
