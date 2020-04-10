package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String FUNCTION_LIST = "## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n";
	private static final String INPUT_FUNCTION_NUMBER_MESSAGE = "## 원하는 기능을 입력하세요";
	private static final String ERROR_MESSAGE_NOT_INTEGER = "숫자가 아닌 문자를 입력하였습니다";

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return inputNumber();
	}

	public static int inputTableNumberWhenPay() {
		System.out.println("## 결제할 테이블을 선택하세요.");
		return inputNumber();
	}

	private static int inputNumber() {
		String input = scanner.next();
		validateNumber(input);
		return Integer.parseInt(input);
	}

	public static int inputAction() {
		System.out.println(FUNCTION_LIST);
		System.out.println(INPUT_FUNCTION_NUMBER_MESSAGE);
		return inputNumber();
	}

	public static int inputMenu() {
		System.out.println("## 등록할 메뉴를 선택하세요");
		return inputNumber();
	}

	public static int inputCount() {
		System.out.println("## 메뉴의 수량을 입력하세요");
		return inputNumber();
	}

	public static void validateNumber(final String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
		}
	}
}
