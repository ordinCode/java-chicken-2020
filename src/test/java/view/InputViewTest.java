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
}
