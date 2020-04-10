package controller;

import view.InputView;

public class ChickenController {
	private static final String EXIT_FUNCTION_NUMBER = "3";

	public static void run() {
		String userInput = InputView.inputAction();
		while (isNotExit(userInput)) {

		}
	}

	public static boolean isNotExit(final String userInput) {
		return !EXIT_FUNCTION_NUMBER.equals(userInput);
	}
}
