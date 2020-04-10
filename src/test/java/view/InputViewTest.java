package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
	@DisplayName("숫자인지 체크")
	@Test
	void validateNumber() {
		String input = "a";

		assertThatThrownBy(() -> InputView.validateNumber(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자가 아닌 문자를 입력하였습니다");
	}

	@DisplayName("1,2,3 이외의 입력시 예외체크")
	@Test
	void validateInputAction() {
		int input = 4;

		assertThatThrownBy(() -> InputView.validateInputAction(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1, 2, 3 중 하나를 입력하세요");
	}
}
