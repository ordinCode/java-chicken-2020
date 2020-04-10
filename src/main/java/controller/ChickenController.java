package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {
	private static final int FUNCTION_NUMBER_REGISTER_ORDER = 1;
	private static final int FUNCTION_ORDER_PAY = 2;
	private static final int FUNCTION_NUMBER_EXIT = 3;

	public static void run() {
		int userInput = InputView.inputAction();
		while (isNotExit(userInput)) {
			if (userInput == FUNCTION_NUMBER_REGISTER_ORDER) {
				registerOrder();
			}
			if (userInput == FUNCTION_ORDER_PAY) {
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

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);

		final int menuNumber = InputView.inputMenu();
		final int menuCount = InputView.inputCount();
	}

	public static boolean isNotExit(final int userInput) {
		return FUNCTION_NUMBER_EXIT != userInput;
	}
}
