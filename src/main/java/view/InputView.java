package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
	private static final String FUNCTION_LIST = "## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n";
	private static final String INPUT_FUNCTION_NUMBER_MESSAGE = "## 원하는 기능을 입력하세요";
	private static final String ERROR_MESSAGE_NOT_INTEGER = "숫자가 아닌 문자를 입력하였습니다";
	private static final String INPUT_MESSAGE_PAYMENT_FORM = "## %d번 테이블의 결제를 진행합니다.\n신용카드는 1번, 현금은 2번";
	private static final String INPUT_MESSAGE_MENU_COUNT = "## 메뉴의 수량을 입력하세요";
	private static final String INPUT_MESSAGE_MENU = "## 등록할 메뉴를 선택하세요";
	private static final String INPUT_MESSAGE_TABLE_NUMBER_TO_PAY = "## 결제할 테이블을 선택하세요.";
	private static final String INPUT_MESSAGE_TABLE_NUMBER_TO_ORDER = "## 주문할 테이블을 선택하세요.";
	private static final String ERROR_MESSAGE_ACTION_NUMBER = "1, 2, 3 중 하나를 입력하세요";
	private static final String ERROR_MESSAGE_PAYMENT_NUMBER = "1, 2 중 입력하세요";
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputAction() {
		System.out.println(FUNCTION_LIST);
		System.out.println(INPUT_FUNCTION_NUMBER_MESSAGE);
		int number = inputNumber();
		validateInputAction(number);
		return number;
	}

	public static void validateInputAction(final int number) {
		if (Arrays.asList(ONE, TWO, THREE).contains(number)) {
			return;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_ACTION_NUMBER);
	}

	private static int inputNumber() {
		String input = scanner.next();
		validateNumber(input);
		return Integer.parseInt(input);
	}

	public static int inputTableNumber() {
		System.out.println(INPUT_MESSAGE_TABLE_NUMBER_TO_ORDER);
		return inputNumber();
	}

	public static int inputTableNumberWhenPay() {
		System.out.println(INPUT_MESSAGE_TABLE_NUMBER_TO_PAY);
		return inputNumber();
	}

	public static int inputMenu() {
		System.out.println(INPUT_MESSAGE_MENU);
		return inputNumber();
	}

	public static int inputCount() {
		System.out.println(INPUT_MESSAGE_MENU_COUNT);
		return inputNumber();
	}

	public static void validateNumber(final String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
		}
	}

	public static int inputFormOfPayment(final int tableNumber) {
		System.out.println(String.format(INPUT_MESSAGE_PAYMENT_FORM, tableNumber));
		int inputNumber = inputNumber();
		validateInputFormOfPayment(inputNumber);
		return inputNumber;
	}

	private static void validateInputFormOfPayment(final int inputNumber) {
		if (Arrays.asList(ONE, TWO).contains(inputNumber)) {
			return;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_PAYMENT_NUMBER);
	}
}
