package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {
	private static final String EXIT_FUNCTION_NUMBER = "3";
	private static final String REGISTER_ORDER_FUNCTION_NUMBER = "1";
	private static final String PAY_FUNCTION_ORDER = "2";

	public static void run() {
		String userInput = InputView.inputAction();
		while (isNotExit(userInput)) {
			if (userInput.equals(REGISTER_ORDER_FUNCTION_NUMBER)) {
				registerOrder();
			}
			if (userInput.equals(PAY_FUNCTION_ORDER)) {
				pay();
			}
			userInput = InputView.inputAction();
		}
	}

	private static void pay() {

	}

	private static void registerOrder() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);

		final String tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);

		final String menuNumber = InputView.inputMenu();
		final String menuCount = InputView.inputCount();


	}

	public static boolean isNotExit(final String userInput) {
		return !EXIT_FUNCTION_NUMBER.equals(userInput);
	}
}
